package pl.coderslab.projectx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.projectx.domain.Event;
import pl.coderslab.projectx.domain.User;
import pl.coderslab.projectx.service.EventService;
import pl.coderslab.projectx.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventFormController {
    private final EventService eventService;
    private final UserService userService;

    public EventFormController(EventService eventsService, UserService userService) {
        this.eventService = eventsService;
        this.userService = userService;
    }

    @GetMapping("/add")           //w jsp eventform z listy nie wybiera userow
    public String eventFormAdd(Model model) {
        model.addAttribute("event", new Event());
        return "eventform";
    }

    @PostMapping("/add")
    public String saveEvent(Event events) {
        eventService.saveEvents(events);
        return "redirect:/event/list";

    }

    @GetMapping("/list")
    public String showEvents(Model model) {
        model.addAttribute("event", eventService.findAll());
        return "listevent";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("event",eventService.findById(id));
        return "eventform";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        eventService.delete(id);
        return "redirect:/event/list";
    }
    @ModelAttribute("users")
    public List<User> users(){
        return userService.findAll();
    }
}
