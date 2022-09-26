package pl.coderslab.projectx.service;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.projectx.domain.Event;
import pl.coderslab.projectx.domain.Expense;
import pl.coderslab.projectx.dto.Summary;
import pl.coderslab.projectx.repository.ExpenseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(Expense expense) {
        expenseRepository.save(expense);
        return expense;
    }

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(Long id) {
        return expenseRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }

//    public List<Expense> allCostByEvent(@Param("eve") Expense expense){
//       return expenseRepository.findExpensesByEvent_Id((long id) ;
//    }

//    public List<Expense> allCost(Expense expense){
//        return expenseRepository.findByEvent(findById(id))
//    }

    public List<Expense> allCost(long id) {
        return expenseRepository.findByEventId(id);
    }

    public Map<String, Double> allUserCost(List<Expense> expenses) {
        Map<String, Double> userCostsMap = new HashMap<>();
        for (Expense exp : expenses) {
            String nameKey = exp.getUser().getName();
            if (userCostsMap.containsKey(nameKey)) {
                userCostsMap.put(nameKey, userCostsMap.get(nameKey) + exp.getCost());
            } else {
                userCostsMap.put(nameKey, exp.getCost());
            }
        }
        return userCostsMap;
    }

    public Summary allCostSummary(Map<String, Double> userCostsMap) {
        Summary summary = new Summary();
        Double sumAmount = 0d;
        for (String key : userCostsMap.keySet()) {
            sumAmount += userCostsMap.get(key);
        }

        summary.setSumAmount(sumAmount);
        summary.setSumUser(userCostsMap.size());
//        summary.setAvg(sumAm);
        return summary;

    }
}
