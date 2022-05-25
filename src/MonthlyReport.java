public class MonthlyReport {
    private String itemName;
    private boolean isExpense;
    private double quantity;
    private double sumOfOne;
    // использую double для по сути int значений, так как при дальнейших рассчетах все равно пришлось бы переводить в double

    public MonthlyReport(String itemName, boolean isExpense, double quantity, double sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean getIsExpense() {
        return isExpense;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getSumOfOne() {
        return sumOfOne;
    }
}
