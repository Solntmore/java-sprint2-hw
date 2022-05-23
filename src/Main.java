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
            String command = scanner.nextLine();
                if (command.equals("1")) {
                    monthReportCommands.monthRecorder();
                    System.out.println("Считывание полностью завершено\n");

                } else if (command.equals("2")) {
                    yearReportCommands.yearRecorder();
                    System.out.println("Считывание завершено.\n");

                } else if (command.equals("3")) {
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
                        System.out.println("Если они есть, проверьте отчетность и повторите операцию.\n");

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Вы не считали отчеты. Перед сверкой, считайте оба отчета, " +
                                "затем повторите операцию\n");
                    }
                } else if (command.equals("4")) {
                    try {
                        monthReportCommands.showAllMonthsStatistic();
                    } catch (NullPointerException e) {
                        System.out.println("Вы не считали месячные отчеты. Выполните считывание и повторите операцию.\n");
                    }
                } else if (command.equals("5")) {
                    try {
                        yearReportCommands.showYearStatistic();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Вы не считали годовой отчет. Выполните считывание и повторите операцию.\n");
                    }
                } else if (command.equals("0")) {
                    System.out.println("Работа завершена.\n");
                    break;

                } else {
                    System.out.println("Такой команды нет, попробуйте еще раз.\n");

                }
            }
        }




    private static void printMenu() {
        System.out.println("Какое действие вы хотите выполнить?\n");
        System.out.println("1 – Считать все месячные отчёты.");
        System.out.println("2 – Считать годовой отчёт.");
        System.out.println("3 – Сверить отчёты.");
        System.out.println("4 – Вывести информацию о всех месячных отчётах.");
        System.out.println("5 – Вывести информацию о годовом отчёте.");
        System.out.println("0 – Завершить работу.\n");
    }


}

