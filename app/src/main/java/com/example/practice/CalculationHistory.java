package com.example.practice;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {

    private static final List<CalculationItem> historyList = new ArrayList<>();

    public static class CalculationItem {
        private final double prelim;
        private final double midterm;
        private final double prefinal;
        private final double finalGrade;
        private final double average;
        private final String remark;

        public CalculationItem(double prelim, double midterm, double prefinal, double finalGrade, double average, String remark) {
            this.prelim = prelim;
            this.midterm = midterm;
            this.prefinal = prefinal;
            this.finalGrade = finalGrade;
            this.average = average;
            this.remark = remark;
        }

        public double getPrelim() {
            return prelim;
        }

        public double getMidterm() {
            return midterm;
        }

        public double getPrefinal() {
            return prefinal;
        }

        public double getFinalGrade() {
            return finalGrade;
        }

        public double getAverage() {
            return average;
        }

        public String getRemark() {
            return remark;
        }
    }

    public static void addCalculation(double prelim, double midterm, double prefinal, double finalGrade, double average, String remark) {
        historyList.add(new CalculationItem(prelim, midterm, prefinal, finalGrade, average, remark));
    }

    public static List<CalculationItem> getHistoryList() {
        return historyList;
    }

    public static void clearHistory() {
        historyList.clear();
    }
}
