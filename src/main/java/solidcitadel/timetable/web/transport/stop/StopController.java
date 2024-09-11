package solidcitadel.timetable.web.transport.stop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import solidcitadel.timetable.domain.transport.stop.Stop;
import solidcitadel.timetable.domain.transport.stop.StopRepository;

import java.util.List;

@Controller
@RequestMapping("/stops")
@RequiredArgsConstructor
public class StopController {
    private final StopRepository stopRepository;

    @GetMapping
    public String stops(Model model){
        List<Stop> stops = stopRepository.findAll();
        model.addAttribute("stops", stops);
        return "/stops/stops";
    }
}

