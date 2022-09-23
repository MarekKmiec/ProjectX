package pl.coderslab.projectx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.projectx.domain.Expenses;
import pl.coderslab.projectx.domain.User;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
}
