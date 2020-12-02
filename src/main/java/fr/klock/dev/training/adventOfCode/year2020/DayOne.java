package fr.klock.dev.training.adventOfCode.year2020;

import java.util.Arrays;

public class DayOne {

    public boolean sumIs2020(int... entries) {
        return Arrays.stream(entries).sum() == 2020;
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

    public int[] find3EntriesThatSumTo2020(int[] expenseReport) {
        for (int i = 0; i < expenseReport.length; i++) {
            for (int j = i; j < expenseReport.length; j++) {
                for (int k = j; k < expenseReport.length; k++) {
                    int a = expenseReport[i];
                    int b = expenseReport[j];
                    int c = expenseReport[k];
                    if (sumIs2020(a, b, c)) {
                        return new int[]{a, b, c};
                    }
                }
            }
        }
        return null;
    }

    public int multiplyExpenseReportEntries(int... entries) {
        int product = 1;
        for (int entry : entries) {
            product = product * entry;
        }
        return product;
    }
}
