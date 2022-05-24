import java.util.ArrayList;
import java.util.HashMap;

public class MonthReportCommands {
    FileReader reader = new FileReader();
    ArrayList<MonthlyReport> monthsArray;
    HashMap<Integer, ArrayList<MonthlyReport>> allMonthMap = new HashMap<>();

    private static final String  DIRECTORY = "resources";
    public void monthRecorder() {

        for (int i = 1; i < 4; i++) {
        String path = DIRECTORY + "\\m.20210" + i + ".csv";
        String content = reader.readFileContentsOrNull(path);
        String[] lines = content.split("\n");
        monthsArray = new ArrayList<>();
            for (int j = 1; j < lines.length; j++) {
                String line = lines[j];
                String[] parts = line.split(",");
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                double quantity = Double.parseDouble(parts[2]);
                double sumOfOne = Double.parseDouble(parts[3]);
                MonthlyReport monthlyReport = new MonthlyReport(itemName, isExpense, quantity, sumOfOne);

             monthsArray.add(monthlyReport);
            }
            allMonthMap.put(i, monthsArray);
        }
    }

    void showAllMonthsStatistic() {

        for (int i = 1; i < 4; i++) {

            ArrayList<MonthlyReport> monthsArray = allMonthMap.get(i);
            double profit = 0.0;
            String profitItemName = "";
            String expenseItemName = "";
            double maxExpense = 0.0;
            for (MonthlyReport monthlyReport : monthsArray) {
                boolean isExpense = monthlyReport.isExpense;
                double quantity = monthlyReport.quantity;
                double sumOfOne = monthlyReport.sumOfOne;
                String maxItemName = monthlyReport.itemName;
                double maxProfit = quantity * sumOfOne;
                if (!isExpense && maxProfit > profit) {
                    profit = maxProfit;
                    profitItemName = maxItemName;
                }
                if (isExpense && sumOfOne > maxExpense) {
                    maxExpense = sumOfOne;
                    expenseItemName = maxItemName;
                }
            }
                System.out.println("Информация за " + i + "-й месяц:");
                System.out.println("Самый прибыльный товар за месяц: " + profitItemName + ". Продано на " + profit + " рублей.");
                System.out.println("Самая большая трата в месяце: " + expenseItemName + ". Потрачено " + maxExpense
                        + " рублей.\n");
        }
    }

    double findMonthExpense(int i) {
    ArrayList<MonthlyReport> monthsArray = allMonthMap.get(i);
    double sumOfExpense = 0;
        for (MonthlyReport monthlyReport : monthsArray) {
            double expense = monthlyReport.sumOfOne;
            boolean isExpense = monthlyReport.isExpense;
            if (isExpense) {
                sumOfExpense += expense;
            }
        }
        return sumOfExpense;
    }

    double findMonthIncome(int i) {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(i);
        double sumOfIncome = 0;
        for (MonthlyReport monthlyReport : monthsArray) {
            double income = monthlyReport.sumOfOne;
            boolean isExpense = monthlyReport.isExpense;
            if (!isExpense) {
                sumOfIncome += income;
            }
        }
        return sumOfIncome;
    }
}
