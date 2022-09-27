package pl.coderslab.projectx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.projectx.domain.Event;
import pl.coderslab.projectx.domain.Expense;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long> {




}
