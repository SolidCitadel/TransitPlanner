package solidcitadel.transitplanner;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import solidcitadel.transitplanner.domain.transport.Time;
import solidcitadel.transitplanner.domain.transport.Type;
import solidcitadel.transitplanner.domain.transport.direction.Direction;
import solidcitadel.transitplanner.domain.transport.direction.DirectionRepository;
import solidcitadel.transitplanner.domain.transport.stop.Stop;
import solidcitadel.transitplanner.domain.transport.stop.StopRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final DirectionRepository directionRepository;
    private final StopRepository stopRepository;

    private HashMap<String, ArrayList<Time>> readFile(){
        HashMap<String, ArrayList<Time>> departureTimeMap = new HashMap<>();
        try{
//            File file = new File("./SampleData.txt");
//            BufferedReader br = new BufferedReader(new FileReader(file));

            InputStream inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("SampleData.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String head = "";
            while (true){
                String line = br.readLine();
                if (line==null)break;
                if (line.charAt(0) == '#'){
                    head = line.substring(1);
                }
                else if (line.charAt(0) == '-') {
                    head = "";
                } else {
                    Integer hour = Integer.parseInt(line.substring(0, 2));
                    Integer min = Integer.parseInt(line.substring(2));
//                    String[] timeString = line.split(":");
                    if (!departureTimeMap.containsKey(head)) {
                        departureTimeMap.put(head, new ArrayList<>());
                    }
                    departureTimeMap.get(head).add(new Time(hour, min));
                }
            }
        } catch (IOException e) {
            log.error(e.toString());
        }
        return departureTimeMap;

    }

    @PostConstruct
    public void init()  {
        HashMap<String, Stop> stopMap = new HashMap<>();
        String[] stops = {"수원", "원주", "정선", "진부"};
        for (String s : stops) {
            stopMap.put(s, stopRepository.save(new Stop(Type.BUS, s)));
        }

        HashMap<String, ArrayList<Time>> departureTimeMap = readFile();
        for (String ss : departureTimeMap.keySet()) {
            ArrayList<Time> times = departureTimeMap.get(ss);
            String[] head = ss.split(" ");
            Direction dir = new Direction(Type.BUS,
                    stopMap.get(head[0]),
                    stopMap.get(head[1]),
                    new Time(Integer.parseInt(head[2]), Integer.parseInt(head[3])),
                    Integer.parseInt(head[4]),
                    times);
            directionRepository.save(dir);
        }
    }

}
