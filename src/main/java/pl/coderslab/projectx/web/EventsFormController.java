package pl.coderslab.projectx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.projectx.domain.Events;
import pl.coderslab.projectx.service.EventsService;

@Controller
@RequestMapping("/event")
public class EventsFormController {
    private final EventsService eventsService;

    public EventsFormController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping("/add")           //w jsp eventform z listy nie wybiera userow
    public String eventFormAdd(Model model) {
        model.addAttribute("events", new Events());
        return "eventform";
    }

    @PostMapping("/add")
    public String saveEvent(Events events) {
        eventsService.saveEvents(events);
        return "redirect:/event/list";

    }

    @GetMapping("/list")
    public String showEvents(Model model) {
        model.addAttribute("events", eventsService.findAll());
        return "listevent";
    }
}
