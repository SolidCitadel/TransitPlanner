package solidcitadel.timetable.web.transport.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import solidcitadel.timetable.domain.transport.direction.Direction;
import solidcitadel.timetable.domain.transport.direction.DirectionRepository;

import java.util.List;

@Controller
@RequestMapping("/directions")
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionRepository directionRepository;

    @GetMapping
    public String directions(Model model) {
        List<Direction> directions = directionRepository.findAll();
        model.addAttribute("directions", directions);
        return "directions/directions";
    }

    @GetMapping("/{directionId}")
    public String direction(@PathVariable long directionId, Model model) {
        Direction direction = directionRepository.findById(directionId);
        model.addAttribute("direction", direction);
        return "directions/direction";
    }
}
