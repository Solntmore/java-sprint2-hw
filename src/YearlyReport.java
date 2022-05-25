public class YearlyReport {

    private double amount;
    private boolean isExpense;


    public YearlyReport(double amount, boolean isExpense) {
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public double getAmount() {
        return amount;
    }

    public boolean getIsExpense() {
        return isExpense;
    }



}