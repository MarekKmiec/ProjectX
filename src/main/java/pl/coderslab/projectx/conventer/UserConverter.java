package pl.coderslab.projectx.conventer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.projectx.domain.User;
import pl.coderslab.projectx.service.UserService;

public class UserConverter implements Converter<String,User> {
    @Autowired
    private UserService userService;
    @Override
    public User convert(String id) {
        return userService.findById(Long.parseLong(id));
    }
    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }
}
