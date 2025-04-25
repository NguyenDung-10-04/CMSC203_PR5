package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    /**
     * Reads a ragged array of doubles from a text file. Each line is a row; values separated by whitespace.
     * Skip blank lines. Return null if file has no data rows.
     * <p>
     * Input file example (input.txt):
     * 1.0 2.5
     * 3.0 4.0 5.0
     * <p>
     * 6.5
     * <p>
     * => [1.65 4.50 2.36]
     * => [2.22 -3.24 -1.66]
     * => [4.23 2.29 5.29]
     * <p>
     * arr[][]
     * [ [ ],
     * [ ],
     * [ ]   ]
     *
     * @param file the file to read from
     * @return a ragged double[][], or null if file is empty
     * @throws FileNotFoundException if the file cannot be found
     *                               split
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner fi = new Scanner(file);
        int rowIndex = 0; // Không biết trước số dòng ( không dùng for loop để gán được mà phải dùng rowIndex + while)
        // row = double [] =>
        // row = double [] =>
        // row = double [] =>
        ArrayList<double []> arr = new ArrayList<>();
        // double[][] arr = new double[][]; //gán các số trong file vào arr
        while (fi.hasNextLine() ) {
            String line = fi.nextLine().trim(); // Lấy ra từng dòng ( String) "1" "2" "3" "4"
            String[] str = line.split("\\s+"); // [1.65,4.50,2.36,7.45,3.44,6.23]
            double [] row = new double[str.length];
            for (int i = 0; i < str.length; i++) {
                    row[i] = Double.parseDouble(str[i]);
            }
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


    /**
     * Writes a ragged array of doubles to a text file. One row per line, values separated by spaces.
     * Skip any null rows.
     * <p>
     * Input array:
     * {{1.1, 2.2}, null, {3.3}}
     * <p>
     * Output file (out.txt):
     * 1.1 2.2
     * 3.3
     *
     * @param data       the ragged array to write
     * @param outputFile the file to write to
     * @throws FileNotFoundException if the file cannot be created
     *                               pw.print()
     *                               123
     *                               423
     *                               125
     */
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


    /**
     * Returns the sum of all values in the ragged array, skipping null rows.
    =>datum: 1 2 3 4 5
    =>datum: 1 2 3
    =>datum: 4 5 6 7
     */
    public static double getTotal(double[][] data) {
        double sum = 0;
        for (double[] datum : data) {
            for (double v : datum) {
                sum += v;
            }
        }
        return sum;
    }


    /**
     * Returns the average of all values in the ragged array. If there are no values, return 0.
     * <p>
     * Input: {{1,2}, {3,4,5}, {}} → Output: 3.0
     *
     * @param data the ragged array
     * @return the average value
     */
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


    /**
     * Returns the sum of the specified row. If row index is out of bounds or row is null, return 0.
     * <p>
     * Input: {
     * -> row = 0 :  {1,2,3},
     * {4,5}
     * }, row=0 → 6.0; row = 1 → 9.0; row=2 → 0.0
     *
     * @param data the ragged array
     * @return the row total
     *
     * 5.	Method getRowTotal – pass in a two-dimensional ragged array of doubles
     * and a row index and returns the total of that row. Row index 0 is the first row
     * in the array.
     * => [1,2,3]
     * => [4,5]
     * => [1,2,3,4,5]
     size,length
     data[]
     */
    public static double getRowTotal(double[][] data, int rowIndex) {
        double sum = 0;
        //rowIndex: cái mình nhập vào
        for(int j = 0; j < data[rowIndex].length; j++){
            sum += data[rowIndex][j]; // row = 0

        }

        return sum;
    }


    /*
        /**
         * Returns the sum of the specified column across all rows that have that column.
         * Missing columns or null rows contribute 0.
         * <p>
         * Input: {{1,2}, {3}, {4,5,6}}
         * col=0 → 8.0; col=1 → 7.0; col=2 → 6.0; col=3 → 0.0
         *
         * @param data the ragged array
         * @param col  the column index
         * @return the column total
         */
    public static double getColumnTotal(double[][] data, int col) {
        double sum = 0;
        for (int i = 0; i < data[col].length; i++){
            sum += data[col][i];
        }
        return sum;
    }


    /**
     * Returns the highest value in the specified row. If row is out of bounds, null, or empty, return NaN.
     * <p>
     * Input: {{1,9,3}, {}}; row=0 → 9.0; row=1 → NaN; row=2 → NaN
     *
     * @param data the ragged array
     * @param row  the row index
     * @return the highest in row or NaN
     */
    public static double getHighestInRow(double[][] data, int row) {
        double max = data[row][0];
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
            }
        }
        return max;
    }


    /**
     * Returns the index of the first highest value in the specified row. If invalid, return -1.
     * <p>
     * Input: {{5,7,7,2}}; row=0 → 1; row=1 → -1
     *
     * @param data the ragged array
     * @param row  the row index
     * @return index of highest or -1
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        int pos = -1;
        double max = Double.MIN_VALUE; // arr[0];  Double.MIN_VALUE( -99999999)
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                pos = i;
            }

        }

        return pos;
    }


    /**
     * Returns the lowest value in the specified row. If row is invalid, return NaN.
     * <p>
     * Input: {{5,7,2,2}}; row=0 → 2.0; row=1 → NaN
     *
     * @param data the ragged array
     * @param row  the row index
     * @return the lowest in row or NaN
     */
    public static double getLowestInRow(double[][] data, int row) {
        double min = data[row][0];
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
            }
        }
        return min;
    }


    /**
     * Returns the index of the first lowest value in the specified row. If invalid, return -1.
     * <p>
     * Input: {{5,7,2,2}}; row=0 → 2; row=1 → -1
     *
     * @param data the ragged array
     * @param row  the row index
     * @return index of lowest or -1
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        int pos = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                pos = i;
            }
        }
        return pos;
    }


    /**
     * Returns the highest value in the specified column. If none, return NaN.
     * <p>
     * Input: {{1,9}, {5}, {2,7,8}}
     * col=0 → 5.0; col=1 → 9.0; col=2 → 8.0; col=3 → NaN
     *
     * @param data the ragged array
     * @param col  the column index
     * @return highest in column or NaN
     * 1 2 3 4 ...
     * 5 6 7 5 7
     * 1 2 3
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.MIN_VALUE; // [0][0]
        for (double[] datum : data) {
            if (datum[col] > max) {
                max = datum[col];
            }
        }
        return max;
    }


    /**
     * Returns the row index of the first highest value in the specified column. If none, return -1.
     * <p>
     * Input: same as getHighestInColumn example; col=0 → 1; col=1 → 0; col=2 → 2; col=3 → -1
     *
     * @param data the ragged array
     * @param col  the column index
     * @return row index of highest or -1
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int pos = -1;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i][col] > max) {
                max = data[i][col];
                pos = i;
            }
        }
        return pos;
    }


    /**
     * Returns the lowest value in the specified column. If none, return NaN.
     * <p>
     * Input: {{1,9}, {5}, {2,7,8}}
     * col=0 → 1.0; col=1 → 7.0; col=2 → 8.0; col=3 → NaN
     *
     * @param data the ragged array
     * @param col  the column index
     * @return lowest in column or NaN
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.MAX_VALUE;
        for (double[] datum : data) {
            if (datum[col] < min) {
                min = datum[col];
            }
        }
        return min;
    }


    /**
     * Returns the row index of the first lowest value in the specified column. If none, return -1.
     * <p>
     * Input: same as getLowestInColumn example; col=0 → 0; col=1 → 2; col=2 → 2; col=3 → -1
     *
     * @param data the ragged array
     * @param col  the column index
     * @return row index of lowest or -1
     * 5 7 8 3 4
     * => -1
     * col = 2 => minIndex = 0 (giả sử nhiều gía trị = nhau => giá trị đầu tiên thỏa mãn)
     * {10, 5, 5},
     * {8, 12, 5},
     * {9, 3,  5}
     * col = 4,5 ( return = -1)
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int pos = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i][col] < min) {
                min = data[i][col];
                pos = i;
            }
        }
        return pos;
    }


    /**
     * Returns the highest value in the entire array. If no values, return NaN.
     * <p>
     * Input: {{1,2}, null, {3,-5}} → 3.0
     *
     * @param data the ragged array
     * @return highest overall or NaN
     */
    public static double getHighestInArray(double[][] data) {
        double max = data[0][0];
        for (double[] datum : data) {
            for (double v : datum) {
                if (v > max) {
                    max = v;
                    break;
                }
            }
        }
        return max;
    }


    /**
     * Returns the lowest value in the entire array. If no values, return NaN.
     * <p>
     * Input: same as getHighestInArray example → -5.0
     *
     * @param data the ragged array
     * @return lowest overall or NaN
     */
    public static double getLowestInArray(double[][] data) {
        double min = data[0][0];
        for (double[] datum : data) {
            for (double v : datum) {
                if (v < min) {
                    min = v;
                    break;
                }
            }
        }
        return min;
    }
}





