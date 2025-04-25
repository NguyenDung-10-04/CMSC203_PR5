package org.example;

public class ExampleReadFile {
    public static void main(String[] args) {
        String[] arr1 = {"1", "1", "1"};

        int[][] arr = new int[3][3];
        int rowIndex = 0;

        // Read file:
//        for (int i = 0; i < arr1.length; i++) {
//            arr[0][i] = Integer.parseInt(arr1[i]);
//        }
//        for (int i = 0; i < arr1.length; i++) {
//            arr[1][i] = Integer.parseInt(arr1[i]);
//        }
//        for (int i = 0; i < arr1.length; i++) {
//            arr[2][i] = Integer.parseInt(arr1[i]);
//        }

        while (rowIndex < 3) {
            for (int i = 0; i < arr1.length; i++) {
                arr[rowIndex][i] = Integer.parseInt(arr1[i]);
            }
            rowIndex++;
        }

        // Print arr
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
