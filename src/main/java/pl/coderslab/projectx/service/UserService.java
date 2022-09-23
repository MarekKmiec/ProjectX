package pl.coderslab.projectx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.projectx.domain.User;
import pl.coderslab.projectx.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
      return  userRepository.findById(id).orElseThrow();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
