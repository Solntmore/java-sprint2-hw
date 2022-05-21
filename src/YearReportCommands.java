import java.util.ArrayList;

public class YearReportCommands {
    FileReader reader = new FileReader();
    ArrayList<YearlyReport> yearArray = new ArrayList<>();
    public void recorder() {
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

    /* есть идея сделать ветвление при выводе в зависимости от того, положительное, отрицательное или нулевое значение
    profit. Соответственно, для каждого свой вариант вывода, ведь прибыли может и не быть в каком-то месяце.
    Не стал реализовывать, чтобы не заграмождать код и не по тз. Стоило/стоит сделать? */
    public void showYearStatistic() {

        System.out.println("Информация о годовом отчете за 2021 год");
        System.out.println("Прибыль за январь составила: " + FirstMonthProfit() + "рублей.");
        System.out.println("Прибыль за январь составила: " + SecondMonthProfit() + "рублей.");
        System.out.println("Прибыль за январь составила: " + ThirdMonthProfit() + "рублей.");
        System.out.println("Средний расход за все месяцы в году составил: " + findAvarageExpense() + " рублей.");
        System.out.println("Средний доход за все месяцы в году составил: " + findAvarageIncome() + " рублей.");


    }

    double findAvarageExpense() {
        double avarageExpenses = 0.0;
        double sumMonths = 0.0;
        double sumExpenses = 0.0;
        for (int i = 0; i < yearArray.size(); i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(isExpense == true) {
                sumExpenses += amount;
                sumMonths += 1.0;
            }
        }
        avarageExpenses = sumExpenses/sumMonths;
        return avarageExpenses;
    }

    double findAvarageIncome() {
        double avarageIncome = 0.0;
        double sumMonths = 0.0;
        double sumIncomes = 0.0;
        for (int i = 0; i < yearArray.size(); i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(isExpense == false) {
                sumIncomes += amount;
                sumMonths += 1.0;
            }
        }
        avarageIncome = sumIncomes/sumMonths;
        return avarageIncome;
    }

    double FirstMonthProfit () {
        double totalProfit = 0.0;
        for (int i = 0; i < 1; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;

            if(isExpense == false) {
                totalProfit += amount;
            } else {
                totalProfit -= amount;
            }

        }
        return totalProfit;

    }

    double SecondMonthProfit () {
        double totalProfit = 0.0;
        for (int i = 2; i < 3; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;

            if(isExpense == false) {
                totalProfit += amount;
            } else {
                totalProfit -= amount;
            }

        }
        return totalProfit;

    }

    double ThirdMonthProfit () {
        double totalProfit = 0.0;
        for (int i = 4; i < 5; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;

            if(isExpense == false) {
                totalProfit += amount;
            } else {
                totalProfit -= amount;
            }

        }
        return totalProfit;

    }

    double firstMonthExpense() {
        double sumOfExpense = 0.0;
        for (int i = 0; i < 1; i++) {
            boolean isExpense = yearArray.get(i).isExpense;
            double amount = yearArray.get(i).amount;
            if(isExpense == true) {
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
            if(isExpense == true) {
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
            if(isExpense == true) {
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
            if(isExpense == false) {
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
            if(isExpense == false) {
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
            if(isExpense == false) {
                sumOfIncome += amount;
            }
        }
        return sumOfIncome;
    }



    }




