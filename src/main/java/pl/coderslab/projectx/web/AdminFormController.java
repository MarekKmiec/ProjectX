package pl.coderslab.projectx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.projectx.domain.Admin;
import pl.coderslab.projectx.service.AdminService;

@Controller
public class AdminFormController {
    private final AdminService adminService;

    public AdminFormController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public ModelAndView show() {
        return new ModelAndView("login");
    }

    @PostMapping("/")
    public String showPages(@RequestParam String name, @RequestParam String password) {
        Admin admin = adminService.findById(1);
        if (name.equals(admin.getLogin()) && password.equals(admin.getPassword())) {
            return "redirect:/userform/list";
        }
            return "redirect:/";
    }
}
