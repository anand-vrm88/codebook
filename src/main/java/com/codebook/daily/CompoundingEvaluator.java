package com.codebook.daily;

import java.text.DecimalFormat;

public class CompoundingEvaluator {

    private static double calculateFixedPrinciple(double amount, float rate, int occurrence) {
        double sum = amount;
        for (int index = 0; index < occurrence; index++) {
            sum = sum * (1 + rate);
        }
        return sum;
    }

    private static double calculateRecurringPrinciple(double amount, float rate, int occurrence) {
        double sum = 0;
        for (int index = 0; index < occurrence; index++) {
            sum += amount;
            sum = sum * (1 + rate);
        }
        return sum;
    }

    private static double calculateRecurringDeposit(double recurringPrinciple, float yearlyRate, int years) {
        float monthlyRate = yearlyRate / 12;
        int months = years * 12;
        return calculateRecurringPrinciple(recurringPrinciple, monthlyRate, months);
    }

    private static double calculateFixedDeposit(double recurringPrinciple, float yearlyRate, int years) {
        float monthlyRate = yearlyRate / 12;
        int months = years * 12;
        return calculateFixedPrinciple(recurringPrinciple, monthlyRate, months);
    }

    public static void main(String[] args) {
        int principleAmount = 50000;
        float yearlyRate = 0.13f;
        int years = 25;

        printAssetDetails("Recurring deposit",
                principleAmount * years * 12,
                calculateRecurringDeposit(principleAmount, yearlyRate, years));
        printAssetDetails("Lump sum deposit",
                principleAmount,
                calculateFixedDeposit(principleAmount, yearlyRate, years));
    }

    private static void printAssetDetails(String text, int principleAmount, double sum) {
        DecimalFormat df=new DecimalFormat("#,###.00");
        System.out.printf(
                "%s | Principle = %s, Sum = %s \n", text, df.format(principleAmount), df.format(sum)
        );
    }

}
