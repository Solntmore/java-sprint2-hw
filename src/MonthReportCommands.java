import java.util.ArrayList;
import java.util.HashMap;

public class MonthReportCommands {
    FileReader reader = new FileReader();
    ArrayList<MonthlyReport> monthsArray;
    HashMap<Integer, ArrayList> allMonthMap = new HashMap<>();


    public void MonthRecorder() {
        for (int i = 1; i < 4; i++) {
            String path = "resources\\m.20210" + i + ".csv";
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
        System.out.println("Информация за январь:");
        showFirstMonthStatistic();
        System.out.println("Информация за февраль:");
        showSecondMonthStatistic();
        System.out.println("Информация за март:");
        showThirdMonthStatistic();
    }

    void showFirstMonthStatistic() {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(1);
        double profit = 0.0;
        String itemName = "";

        for (int i = 0; i < monthsArray.size(); i++) {
            boolean isExpense = monthsArray.get(i).isExpense;
            double quantity = monthsArray.get(i).quantity;
            double sumOfOne = monthsArray.get(i).sumOfOne;
            String maxItemName = monthsArray.get(i).itemName;
            double maxProfit = quantity*sumOfOne;
            if (isExpense == false && maxProfit > profit) {
                profit = maxProfit;
                itemName = maxItemName;
            }
        }
        System.out.println("Самый прибыльный товар за месяц: " + itemName + ". Продано на " + profit + " рублей.");
        double maxExpense = 0.0;
        for (int i = 0; i < monthsArray.size(); i++) {
            boolean isExpense = monthsArray.get(i).isExpense;
            double expense = monthsArray.get(i).sumOfOne;
            String maxItemName = monthsArray.get(i).itemName;
            if(isExpense == true && expense > maxExpense) {
                maxExpense = expense;
                itemName = maxItemName;
            }
        }
        System.out.println("Самая большая трата в месяце: " + itemName + ". Продано на " + maxExpense + " рублей.");
    }

    void showSecondMonthStatistic() {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(2);
        double profit = 0.0;
        String itemName = "";

        for (int i = 0; i < monthsArray.size(); i++) {
            boolean isExpense = monthsArray.get(i).isExpense;
            double quantity = monthsArray.get(i).quantity;
            double sumOfOne = monthsArray.get(i).sumOfOne;
            String maxItemName = monthsArray.get(i).itemName;
            double maxProfit = quantity*sumOfOne;
            if (isExpense == false && maxProfit > profit) {
                profit = maxProfit;
                itemName = maxItemName;
            }
        }
        System.out.println("Самый прибыльный товар за месяц: " + itemName + ". Продано на " + profit + " рублей.");
        double maxExpense = 0.0;
        for (int i = 0; i < monthsArray.size(); i++) {
            boolean isExpense = monthsArray.get(i).isExpense;
            double expense = monthsArray.get(i).sumOfOne;
            String maxItemName = monthsArray.get(i).itemName;
            if(isExpense == true && expense > maxExpense) {
                maxExpense = expense;
                itemName = maxItemName;
            }
        }
        System.out.println("Самая большая трата в месяце: " + itemName + ". Продано на " + maxExpense + " рублей.");
    }

    void showThirdMonthStatistic() {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(3);
        double profit = 0.0;
        String itemName = "";

        for (int i = 0; i < monthsArray.size(); i++) {
            boolean isExpense = monthsArray.get(i).isExpense;
            double quantity = monthsArray.get(i).quantity;
            double sumOfOne = monthsArray.get(i).sumOfOne;
            String maxItemName = monthsArray.get(i).itemName;
            double maxProfit = quantity*sumOfOne;
            if (isExpense == false && maxProfit > profit) {
                profit = maxProfit;
                itemName = maxItemName;
            }
        }
        System.out.println("Самый прибыльный товар за месяц: " + itemName + ". Продано на " + profit + " рублей.");
        double maxExpense = 0.0;
        for (int i = 0; i < monthsArray.size(); i++) {
            boolean isExpense = monthsArray.get(i).isExpense;
            double expense = monthsArray.get(i).sumOfOne;
            String maxItemName = monthsArray.get(i).itemName;
            if(isExpense == true && expense > maxExpense) {
                maxExpense = expense;
                itemName = maxItemName;
            }
        }
        System.out.println("Самая большая трата в месяце: " + itemName + ". Продано на " + maxExpense + " рублей.");
    }

    double firstMonthExpense() {
    ArrayList<MonthlyReport> monthsArray = allMonthMap.get(1);
    double sumOfExpense = 0;
        for (int i = 0; i < monthsArray.size(); i++) {
            double expense = monthsArray.get(i).sumOfOne;
            boolean isExpense = monthsArray.get(i).isExpense;
            if(isExpense == true) {
                sumOfExpense += expense;
            }
        }
        return sumOfExpense;
    }


    double secondMonthExpense() {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(2);
        double sumOfExpense = 0;
        for (int i = 0; i < monthsArray.size(); i++) {
            double expense = monthsArray.get(i).sumOfOne;
            boolean isExpense = monthsArray.get(i).isExpense;
            if(isExpense == true) {
                sumOfExpense += expense;
            }
        }
        return sumOfExpense;
    }

    double thirdMonthExpense() {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(3);
        double sumOfExpense = 0;
        for (int i = 0; i < monthsArray.size(); i++) {
            double expense = monthsArray.get(i).sumOfOne;
            boolean isExpense = monthsArray.get(i).isExpense;
            if(isExpense == true) {
                sumOfExpense += expense;
            }
        }
        return sumOfExpense;
    }

    double firstMonthIncome() {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(1);
        double sumOfIncome = 0;
        for (int i = 0; i < monthsArray.size(); i++) {
            double income = monthsArray.get(i).sumOfOne;
            boolean isExpense = monthsArray.get(i).isExpense;
            if(isExpense == false) {
                sumOfIncome += income;
            }
        }
        return sumOfIncome;
    }

    double secondMonthIncome() {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(2);
        double sumOfIncome = 0;
        for (int i = 0; i < monthsArray.size(); i++) {
            double income = monthsArray.get(i).sumOfOne;
            boolean isExpense = monthsArray.get(i).isExpense;
            if(isExpense == false) {
                sumOfIncome += income;
            }
        }
        return sumOfIncome;
    }

    double thirdMonthIncome() {
        ArrayList<MonthlyReport> monthsArray = allMonthMap.get(3);
        double sumOfIncome = 0;
        for (int i = 0; i < monthsArray.size(); i++) {
            double income = monthsArray.get(i).sumOfOne;
            boolean isExpense = monthsArray.get(i).isExpense;
            if(isExpense == false) {
                sumOfIncome += income;
            }
        }
        return sumOfIncome;
    }


}
