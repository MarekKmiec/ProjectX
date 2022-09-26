package pl.coderslab.projectx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.projectx.domain.Event;
import pl.coderslab.projectx.domain.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

//    @Query("select e from Expense e where e.event= :event", Expense.class)
//    List<Expense> findAllExpensesWithEventId(Expense expense) {
//    }
//        @Query("select e from Expense e where e.event= :eve")
//    List<Expense> findExpensesByEvent_Id(@Param("eve") Expense expense);
//}
//@Query("select e from Expense e where e.event= ?1")
//    List<Expense> queryByEvent(String id){
//}

    List<Expense> findByEventId(Long id);




}
