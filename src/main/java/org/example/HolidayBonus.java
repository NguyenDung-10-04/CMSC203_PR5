package org.example;
/*
 * Class: CMSC203
 * Instructor: Ahmed Tarek
 * Description: Holiday Bonus
 * Due:
 * Platform/compiler: Intelij
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Dung Nguyen
 */

public class HolidayBonus {
    private static final double HIGH_BONUS  = 5000;
    private static final double LOW_BONUS   = 1000;
    private static final double OTHER_BONUS = 2000;

    public static double[] calculateHolidayBonus(double[][] data) {
        if (data == null)    return null;
        int numRows = data.length;
        if (numRows == 0)    return new double[0];

        // 1) Xác định số cột lớn nhất
        int numCols = 0;
        for (double[] row : data) {
            if (row != null && row.length > numCols) {
                numCols = row.length;
            }
        }

        double[] bonuses = new double[numRows];

        // 2) Duyệt từng cột
        for (int j = 0; j < numCols; j++) {
            double max = Double.NEGATIVE_INFINITY;
            double min = Double.POSITIVE_INFINITY;
            int maxIdx = -1;
            int minIdx = -1;

            // a) Tìm max (mọi giá trị) và min (giá trị != 0)
            for (int i = 0; i < numRows; i++) {
                if (data[i] == null || j >= data[i].length) continue;
                double v = data[i][j];

                // tìm max trên mọi v
                if (v > max) {
                    max = v;
                    maxIdx = i;
                }
                // tìm min nhưng bỏ qua v == 0
                if (v != 0 && v < min) {
                    min = v;
                    minIdx = i;
                }
            }

            // b) Gán bonus
            for (int i = 0; i < numRows; i++) {
                if (data[i] == null || j >= data[i].length) continue;
                double v = data[i][j];

                if (v == max) {
                    bonuses[i] += HIGH_BONUS;
                }
                else if (v == min) {
                    bonuses[i] += LOW_BONUS;
                }
                else if (v != 0) {
                    bonuses[i] += OTHER_BONUS;
                }
            }
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] arr = calculateHolidayBonus(data);
        if (arr == null) return 0.0;
        double sum = 0;
        for (double b : arr) sum += b;
        return sum;
    }
}