package org.example;

class HolidayBonus {


    public static double[] calculateHolidayBonus(double[][] data) {
        if (data == null) return null;
        if (data.length == 0) return new double[0];


        double[] bonuses = new double[data.length];

        for (int j = 0; j < data.length; j++) {
            double max = Double.NEGATIVE_INFINITY;
            double min = Double.POSITIVE_INFINITY;

            // Tìm max/min trong cột j (bỏ qua 0 khi tìm min)
            for (double[] datum : data) {
                double value = datum[j];
                if (datum[j] > max) max = value;
                if (datum[j] != 0 && value < min) min = value;
            }

            // Gán thưởng theo giá trị cột j
            for (int i = 0; i < data.length; i++) {
                double value = data[i][j];
                if (value == max) {
                    bonuses[i] += 5000;
                } else if (value == min) {
                    bonuses[i] += 1000;
                } else if (value == 0) {
                    bonuses[i] += 0;
                } else {
                    bonuses[i] += 2000;
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data){
        double sum = 0;
        double[] totalSum = calculateHolidayBonus(data);
        for(double data1 : totalSum){
            sum+= data1;
        }
        return sum;
    }
}