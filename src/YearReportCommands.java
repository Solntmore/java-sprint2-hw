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

    /* Так как в годовом отчете о каждом месяце по 2 строки(убытки и доходы), я сделал цикл шагающий через строку,
     а внутри метода, который запускается в данном цикле выводится текущая и следующая строка, но не далее, чем 2 строки
     от стартовой, чтобы все работало корректно и вывело ровно 3 месяца*/
    public void showYearStatistic() {
        int monthNumber = 0;

        System.out.println("Информация о годовом отчете за 2021 год");
        for (int i = 0; i < 5; i = i + 2) {
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
        for (int i = 0; i < yearArray.size(); i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(isExpense) {
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
        for (int i = 0; i < yearArray.size(); i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(!isExpense) {
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

    double firstMonthExpense() {
        double sumOfExpense = 0.0;
        for (int i = 0; i < 1; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(isExpense) {
                sumOfExpense += amount;
            }
        }
        return sumOfExpense;
    }

    double secondMonthExpense() {
        double sumOfExpense = 0.0;
        for (int i = 2; i < 3; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(isExpense) {
                sumOfExpense += amount;
            }
        }
        return sumOfExpense;
    }

    double thirdMonthExpense() {
        double sumOfExpense = 0.0;
        for (int i = 4; i < 5; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(isExpense) {
                sumOfExpense += amount;
            }
        }
        return sumOfExpense;
    }

    double firstMonthIncome() {
        double sumOfIncome = 0.0;
        for (int i = 0; i < 1; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(!isExpense) {
                sumOfIncome += amount;
            }
        }
        return sumOfIncome;
    }

    double secondMonthIncome() {
        double sumOfIncome = 0.0;
        for (int i = 2; i < 3; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(!isExpense) {
                sumOfIncome += amount;
            }
        }
        return sumOfIncome;
    }

    double thirdMonthIncome() {
        double sumOfIncome = 0.0;
        for (int i = 4; i < 5; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(!isExpense) {
                sumOfIncome += amount;
            }
        }
        return sumOfIncome;
    }



    }




