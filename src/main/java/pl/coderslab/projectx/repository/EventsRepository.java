package pl.coderslab.projectx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.projectx.domain.Events;
import pl.coderslab.projectx.domain.User;

import java.util.List;
import java.util.Optional;

public interface EventsRepository extends JpaRepository<Events,Long> {
    Events save(Events events);
    Events saveAndFlush(Events events);

    List<Events> findAll();

    Optional<Events> findById(Long id);

    void deleteById(Long id);

}
