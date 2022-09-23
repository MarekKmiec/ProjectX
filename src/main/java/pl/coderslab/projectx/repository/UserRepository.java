package pl.coderslab.projectx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.projectx.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User save(User user);
    User saveAndFlush(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);







}
