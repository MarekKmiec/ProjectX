package pl.coderslab.projectx.dto;

public class ExpenseDTO {

    public Integer id;
    public String userName;
    public Double cost;

    @Override
    public int hashCode() {
        return id;
    }

    public ExpenseDTO(Integer id, String userName, Double cost) {
        this.id = id;
        this.userName = userName;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
