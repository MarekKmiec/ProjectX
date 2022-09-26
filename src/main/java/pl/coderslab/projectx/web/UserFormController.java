package pl.coderslab.projectx.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.projectx.domain.User;
import pl.coderslab.projectx.service.UserService;

@Controller
@RequestMapping("/userform")
public class UserFormController {

    private final UserService userServive;


    public UserFormController(UserService userServive) {
        this.userServive = userServive;
    }

    @GetMapping("/add")
//    @ResponseBody
    public String userFormAdd(Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/add")
    public String saveUser(User user){
//        if(user.getId()==null){
//            userServive.saveUser(user);
//        } else

        userServive.saveUser(user);
        return "redirect:/userform/list";
    }
    @GetMapping("/list")
    public String showUser(Model model){
        model.addAttribute("user", userServive.findAll());
        return "listuser";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("user",userServive.findById(id));
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        userServive.delete(id);
        return "redirect:/userform/list";
    }
}
