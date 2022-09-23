package pl.coderslab.projectx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "hello Word!!!";
    }

//    @GetMapping("/user/add")
//    public ModelAndView home(){
//        ModelAndView mav = new ModelAndView("form");
//        return mav;
//    }
}
