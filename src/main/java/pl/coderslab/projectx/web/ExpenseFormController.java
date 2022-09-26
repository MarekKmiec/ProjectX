package pl.coderslab.projectx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.projectx.domain.Event;
import pl.coderslab.projectx.domain.Expense;
import pl.coderslab.projectx.domain.User;
import pl.coderslab.projectx.service.EventService;
import pl.coderslab.projectx.service.ExpenseService;
import pl.coderslab.projectx.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/expense")
public class ExpenseFormController {
    private final ExpenseService expenseService;
    private final UserService userService;

    private final EventService eventService;

    public ExpenseFormController(ExpenseService expenseService, UserService userService, EventService eventService) {
        this.expenseService = expenseService;
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("/add")
    public String expenseFormAdd(Model model) {
        model.addAttribute("expense", new Expense());
        return "expenseform";
    }

    @PostMapping("/add")
    public String saveExpense(Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expense/list";
    }

    @GetMapping("/list")
    public String showExpense(Model model) {
        model.addAttribute("expense", expenseService.findAll());
        return "listexpense";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("expense", expenseService.findById(id));
        return "expenseform";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        expenseService.delete(id);
        return "redirect:/expense/list";
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userService.findAll();
    }

    @ModelAttribute("events")
    public List<Event> events() {
        return eventService.findAll();
    }

    @ModelAttribute("expenses")
    public List<Expense> expenses() {
        return expenseService.findAll();
    }


    @GetMapping("/eventcost/{id}")
    public String allEventCost(Model model, @PathVariable long id) {
        List<Expense> expenses = expenseService.allCost(id);
        model.addAttribute("allexpense", expenses);
        Map<String, Double> userCost = expenseService.allUserCost(expenses);
        model.addAttribute("allusercost", userCost);
        model.addAttribute("summary", expenseService.allCostSummary(userCost));
        return "eventcostbyid";
    }


}
