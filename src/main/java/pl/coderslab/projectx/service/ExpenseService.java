package pl.coderslab.projectx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.projectx.domain.Expense;
import pl.coderslab.projectx.dto.ExpenseDTO;
import pl.coderslab.projectx.dto.Summary;
import pl.coderslab.projectx.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
        return summary;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    //    Hyber	95.0	63.6
//    Kwietnik	0.0	-31.4
//    Bojar	35.0	3.6000000000000014
//    Tomo	15.0	-16.4
//    Ivann	12.0	-19.4
    public Map<ExpenseDTO, List<ExpenseDTO>> bild(Map<String, Double> userCostsMap, Summary sum) {
        Map<String, Double> user2Sum = new HashMap<>();
        for (String key : userCostsMap.keySet()) {
            user2Sum.put(key, userCostsMap.get(key) - round(sum.getAvg(),2));
        }

        Map<ExpenseDTO, List<ExpenseDTO>> listBildMap = new HashMap<>(); // do zwrocenia finalna mapa
        Integer index = 0; // index hashCode
        Map<String, Double> givenMap = new HashMap<>(); // ci co maja oddac
        for (String key : user2Sum.keySet()) {
            if (user2Sum.get(key) > 0) {
                listBildMap.put(new ExpenseDTO(index++, key, user2Sum.get(key)), new ArrayList<>());
            } else {
                givenMap.put(key, user2Sum.get(key));
            }
        }
        String toRemove = "";
        for (ExpenseDTO komuDTO : listBildMap.keySet()) {
            Double doOddania = komuDTO.cost; // 63

            if(toRemove != ""){
                System.out.println("kasuje "+toRemove);
                for(String s : toRemove.split(";")){
                    givenMap.remove(s);
                }
                toRemove = "";
                System.out.println("po kasownaiu "+givenMap);
            }
            System.out.println("doOddania "+doOddania);
            System.out.println("komuDTO "+komuDTO.userName);

            for (String givenName : givenMap.keySet()) {
                if(doOddania == 0 ){
                    break;
                }
                Double oddanieMax = Math.abs(givenMap.get(givenName)); // 31
                System.out.println("givenName "+givenName);
                if (doOddania > oddanieMax) {
                    System.out.println("> doOddania "+doOddania);
                    listBildMap.get(komuDTO).add(new ExpenseDTO(index++, givenName, oddanieMax));
                    doOddania = doOddania - oddanieMax;
                    toRemove += ";"+givenName;
                    continue;
                } else if (doOddania == oddanieMax) {
                    System.out.println("= doOddania "+doOddania);
                    listBildMap.get(komuDTO).add(new ExpenseDTO(index++, givenName, oddanieMax));
                    toRemove = ";"+givenName;
                    doOddania = 0d;
                    continue;
                } else { // <
                    System.out.println("< doOddania "+doOddania);
                    listBildMap.get(komuDTO).add(new ExpenseDTO(index++, givenName, doOddania));
                    givenMap.put(givenName, oddanieMax - doOddania);
                    doOddania = 0d;
                    continue;
                }
            }


        }


        return listBildMap;
    }
}
