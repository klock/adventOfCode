package fr.klock.dev.training;

public class AdventOfCode2020 {
    public boolean sumIs2020(int a, int b) {
        return (a+b) == 2020;
    }

    public int[] find2EntriesThatSumTo2020(int[] expenseReport) {
        for (int i = 0; i < expenseReport.length -1; i++) {
            for (int j = i; j < expenseReport.length; j++) {
                int a = expenseReport[i];
                int b = expenseReport[j];
                if (sumIs2020(a, b)) {
                    return new int[]{a, b};
                }
            }
        }
        return null;
    }

    public int multiply2ExpenseReportEntries(int a, int b) {
        return a*b;
    }
}
