package pl.coderslab.projectx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.projectx.domain.User;
import pl.coderslab.projectx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userServive;

    public UserController(UserService userServive) {
        this.userServive = userServive;
    }
    @RequestMapping("/add")
    @ResponseBody
    public String addUser(){
        User user = new User();
        user.setName("Tomoo");
        user.setBalance(0.0);
        user.setPhoneNumber("555555555");
        userServive.saveUser(user);
        return user.toString();

    }
}
