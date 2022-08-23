package ch6;

import java.util.Scanner;

public class PrintCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter full year (e.g., 2022): ");
        int year = input.nextInt();

        System.out.println("Enter month as a number between 1 and 12: ");
        int month = input.nextInt();

        printMonth(year, month);
    }

    private static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    private static void printMonthTitle(int year, int month) {
        System.out.println("        " + getMonthName(month) + " " + year);
        System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
        System.out.println(" 周日 周一 周二 周三 周四 周五 周六");
    }

    private static void printMonthBody(int year, int month) {
        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
        int i = 0;
        for (i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (i = 1; i < numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * 得到指定年月的第一天的星期值
     *
     * @param year
     * @param month
     * @return
     */
    private static int getStartDay(int year, int month) {
        // 已知 1800年1月1日是星期三
        final int START_DAY_FOR_JAN_1_1800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    /**
     * 获取从 1800.1.1 开始的总天数
     *
     * @param year
     * @param month
     * @return
     */
    private static int getTotalNumberOfDays(int year, int month) {
        int total = 0;
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                total += 366;
            } else {
                total += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            total += getNumberOfDaysInMonth(year, i);
        }
        return total;
    }

    /**
     * 得到一个月的天数
     *
     * @param year
     * @param i
     * @return
     */
    private static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return 0;
    }

    /**
     * 判断是否闰年
     *
     * @param year
     * @return
     */
    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }


    private static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "一月";
                break;
            case 2:
                monthName = "二月";
                break;
            case 3:
                monthName = "三月";
                break;
            case 4:
                monthName = "四月";
                break;
            case 5:
                monthName = "五月";
                break;
            case 6:
                monthName = "六月";
                break;
            case 7:
                monthName = "七月";
                break;
            case 8:
                monthName = "八月";
                break;
            case 9:
                monthName = "九月";
                break;
            case 10:
                monthName = "十月";
                break;
            case 11:
                monthName = "十一月";
                break;
            case 12:
                monthName = "十二月";
                break;
        }
        return monthName;
    }
}
