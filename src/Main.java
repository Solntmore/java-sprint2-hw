import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        YearReportCommands yearReportCommands = new YearReportCommands();
        MonthReportCommands monthReportCommands = new MonthReportCommands();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в бухгалтерию 2.0!\n");
        //думаю, что визуально приятнее при выводе будет выглядеть пустая строка между приветствием и выводом меню

        while (true) {
        printMenu();
        int command = scanner.nextInt();


            if (command == 1) {
                monthReportCommands.MonthRecorder();
                System.out.println("Считывание полностью завершено");

            } else if(command == 2) {
                yearReportCommands.recorder();
                System.out.println("Считывание завершено.");

            } else if(command == 3) {
                try {

                    if (yearReportCommands.firstMonthExpense() != monthReportCommands.firstMonthExpense() ||
                            yearReportCommands.firstMonthIncome() != monthReportCommands.firstMonthIncome()) {
                        System.out.println("В первом месяце обнаружены расхождения");
                    }
                    if (yearReportCommands.secondMonthExpense() != monthReportCommands.secondMonthExpense() ||
                            yearReportCommands.secondMonthIncome() != monthReportCommands.secondMonthIncome()) {
                        System.out.println("Во втором месяце обнаружены расхождения");
                    }
                    if (yearReportCommands.thirdMonthExpense() != monthReportCommands.thirdMonthExpense() ||
                            yearReportCommands.thirdMonthIncome() != monthReportCommands.thirdMonthIncome()) {
                        System.out.println("В третьем месяце обнаружены расхождения");
                    }
                    System.out.println("Проверка успешно завершена. Если вы не видите сообщений об ошибке," +
                            " значит проверка прошла успешно.");
                    System.out.println("Если они есть, проверьте отчетность и повторите операцию.");

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Вы не считали отчеты. Перед сверкой, считайте оба отчета, " +
                            "затем повторите операцию");
                }
            } else if(command == 4) {
                try {
                    monthReportCommands.showAllMonthsStatistic();
                } catch (NullPointerException e) {
                    System.out.println("Вы не считали месячные отчеты. Выполните считывание и повторите операцию.");
                }
            } else if(command == 5) {
                try {
                yearReportCommands.showYearStatistic();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Вы не считали годовой отчет. Выполните считывание и повторите операцию.");
                }
            } else if(command == 0) {
                System.out.println("Работа завершена.");
                break;

            } else {
                System.out.println("Такой команды нет, попробуйте еще раз.\n");

            }
        }



    }
    public static void printMenu() {
        System.out.println("Какое действие вы хотите выполнить?");
        System.out.println("1 – Считать все месячные отчёты.");
        System.out.println("2 – Считать годовой отчёт.");
        System.out.println("3 – Сверить отчёты.");
        System.out.println("4 – Вывести информацию о всех месячных отчётах.");
        System.out.println("5 – Вывести информацию о годовом отчёте.");
        System.out.println("0 – Завершить работу.");
    }


}

