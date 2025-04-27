package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner fi = new Scanner(file);
        ArrayList<double []> arr = new ArrayList<>();
        while (fi.hasNextLine() ) {
            String line = fi.nextLine().trim(); // Lấy ra từng dòng ( String) "1" "2" "3" "4"
            String[] str = line.split("\\s+"); // [1.65,4.50,2.36,7.45,3.44,6.23]
            double [] row = new double[str.length];
            for (int i = 0; i < str.length; i++)   row[i] = Double.parseDouble(str[i]);
            arr.add(row);
        }
        fi.close();
        double[][] list2D = new double[arr.size()][];
        for(int i = 0; i < list2D.length; i++){
            //for(int j = 0; j < list2D.length; j++){
            list2D[i]= arr.get(i);
            //  }
        }

        return list2D;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(outputFile);
        for (double[] datum : data) {
            for (double v : datum) {
                pw.print(v + " "); // 1 2 3 4 2 3 1 2 5
                // pw.println();1: 3 * 3
            }
            pw.println(); // 2: 3
        }

        pw.close();
    }

    public static double getTotal(double[][] data) {
        double sum = 0;
        for (double[] datum : data) {
            for (double v : datum) {
                sum += v;
            }
        }
        return sum;
    }

    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        for (double[] datum : data)
            for (double v : datum) {
                count++;
                total += v;
            }
        return total / count;
    }

    public static double getRowTotal(double[][] data, int rowIndex) {
        double sum = 0;
        //rowIndex: cái mình nhập vào
        for(int j = 0; j < data[rowIndex].length; j++){
            sum += data[rowIndex][j]; // row = 0

        }

        return sum;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double sum = 0;
        for (double[] datum : data) {
            if (datum != null && datum.length > col) {
                sum += datum[col];
            }
        }
        return sum;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
            }
        }
        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        int pos = -1;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                pos = i;
            }

        }

        return pos;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
            }
        }
        return min;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        int pos = -1;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                pos = i;
            }
        }
        return pos;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] datum : data) {
            if (datum != null && datum.length > col && datum[col] > max) {
                max = datum[col];
            }
        }
        return max;
    }
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int pos = -1;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].length > col && data[i][col] > max) {
                max = data[i][col];
                pos = i;
            }
        }
        return pos;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] datum : data) {
            if (datum != null && datum.length > col && datum[col] < min) {
                min = datum[col];
            }
        }
        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        int pos = -1;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].length > col && data[i][col] < min) {
                min = data[i][col];
                pos = i;
            }
        }
        return pos;
    }
    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] datum : data) {
            for (double v : datum) {
                if (v > max) max = v;
            }
        }
        return max;
    }

    public static double getLowestInArray(double[][] data) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double v : row) {
                if (v < min) {
                    min = v;
                }
            }
        }
        return min;
    }
}





