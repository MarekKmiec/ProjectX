package pl.coderslab.projectx.dto;

public class Summary {

    private double sumUser = 0;
    private double sumAmount = 0;

//    private double subCost = 0;

    public double getAvg() {
        return sumUser > 0 ? sumAmount / sumUser : 0;
    }

    public double getSumUser() {
        return sumUser;
    }

    public void setSumUser(double sumUser) {
        this.sumUser = sumUser;
    }

    public double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(double sumAmount) {
        this.sumAmount = sumAmount;
    }
}
