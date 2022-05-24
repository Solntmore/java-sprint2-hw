import java.util.ArrayList;

public class YearReportCommands {
    FileReader reader = new FileReader();
    ArrayList<YearlyReport> yearArray = new ArrayList<>();
    public void yearRecorder() {
        String path = "resources\\y.2021.csv";
        String content = reader.readFileContentsOrNull(path);
        String [] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            double amount = Double.parseDouble(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            YearlyReport yearReport = new YearlyReport(month, amount, isExpense);
            yearArray.add(yearReport);
        }



        }

    public void showYearStatistic() {
        int monthNumber = 0;

        System.out.println("Информация о годовом отчете за 2021 год");
        for (int i = 0; i < yearArray.size(); i = i + 2) {
            monthNumber +=1;
            allMonthProfit(i, monthNumber);
        }
        System.out.println("Средний расход за все месяцы в году составил: " + findAvarageExpense() + " рублей.");
        System.out.println("Средний доход за все месяцы в году составил: " + findAvarageIncome() + " рублей.");


    }

    double findAvarageExpense() {
        double avarageExpenses;
        double sumMonths = 0.0;
        double sumExpenses = 0.0;
        for (YearlyReport yearlyReport : yearArray) {
            boolean isExpense = yearlyReport.isExpense;
            double amount = yearlyReport.amount;
            if (isExpense) {
                sumExpenses += amount;
                sumMonths += 1.0;
            }
        }
        avarageExpenses = sumExpenses/sumMonths;
        return avarageExpenses;
    }

    double findAvarageIncome() {
        double avarageIncome;
        double sumMonths = 0.0;
        double sumIncomes = 0.0;
        for (YearlyReport yearlyReport : yearArray) {
            boolean isExpense = yearlyReport.isExpense;
            double amount = yearlyReport.amount;
            if (!isExpense) {
                sumIncomes += amount;
                sumMonths += 1.0;
            }
        }
        avarageIncome = sumIncomes/sumMonths;
        return avarageIncome;
    }

    void allMonthProfit (int i, int monthNumber) {
        double totalProfit = 0.0;
        int monthCounter = 0;
        for (int m = i; m < i + 2 && i < 6; m++) {
            boolean isExpense = yearArray.get(m).isExpense;
            double amount = yearArray.get(m).amount;
            monthCounter += 1;
            if (!isExpense) {
                totalProfit += amount;
            } else {
                totalProfit -= amount;
            }

            if (monthCounter % 2 != 0) {
                if (totalProfit > 0) {
                    System.out.println("Прибыль за " + monthNumber + "-й месяц составила: " + totalProfit + "рублей.");
                } else if (totalProfit < 0) {
                    System.out.println("Убыток за " + monthNumber + "-й месяц составил: " + totalProfit + "рублей.");
                }
            }
        }
    }

    double findMonthExpense(int i) {
        double sumOfExpense = 0.0;
        for (int j = 0; i < j; j++) {
            boolean isExpense = yearArray.get(j).isExpense;
            double amount = yearArray.get(j).amount;
            if(isExpense) {
                sumOfExpense += amount;
            }
        }
        return sumOfExpense;
    }

    double findMonthIncome(int i) {
        double sumOfIncome = 0.0;
        for (int j = 0; j < 1; j++) {
            boolean isExpense = yearArray.get(j).isExpense;
            double amount = yearArray.get(j).amount;
            if(!isExpense) {
                sumOfIncome += amount;
            }
        }
        return sumOfIncome;
    }



    }




