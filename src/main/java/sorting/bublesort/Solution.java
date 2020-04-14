package sorting.bublesort;

import java.util.Scanner;

public class Solution {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        final String result = printCountSwaps(a);
        System.out.println(result);
    }

    static String printCountSwaps(int[] a) {
        int swapsCount = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    swapsCount++;
                }
            }

        }

        int firstElement = a[0];
        int lastElement = a[n - 1];
        
        return String.format("Array is sorted in %d swaps.\nFirst Element: %d\nLast Element: %d", swapsCount, firstElement, lastElement);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
