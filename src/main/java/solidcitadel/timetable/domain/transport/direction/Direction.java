package solidcitadel.timetable.domain.transport.direction;

import lombok.Data;
import solidcitadel.timetable.domain.transport.Time;
import solidcitadel.timetable.domain.transport.Type;
import solidcitadel.timetable.domain.transport.stop.Stop;

import java.util.ArrayList;

@Data
public class Direction {
    private Long id;
    private Type type;
    private Stop departure;
    private Stop destination;
    private Time requiredTime;
    private Integer fare;
    private ArrayList<Time> departureTimes;

    public Direction(Type type, Stop departure, Stop destination, Time requiredTime, Integer fare, ArrayList<Time> departureTimes) {
        this.type = type;
        this.departure = departure;
        this.destination = destination;
        this.requiredTime = requiredTime;
        this.fare = fare;
        this.departureTimes = departureTimes;
    }
}
