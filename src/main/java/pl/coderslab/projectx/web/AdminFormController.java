package pl.coderslab.projectx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
//    public ModelAndView show() {
//        return new ModelAndView("login");
    public String show(Model model){
        model.addAttribute("admin", new Admin());
        return "login";
    }

    @PostMapping("/")
//    public String showPages(@RequestParam String name, @RequestParam String password) {
    public String showPages(Admin admin) {
         Admin admin1=adminService.findById(1);
        if (admin.getLogin().equals(admin1.getLogin()) && admin.getPassword().equals(admin1.getPassword())) {
            return "redirect:/userform/list";
        }
            return "redirect:/";
    }
}
