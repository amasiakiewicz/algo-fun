package greedy.maxmin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        int minDiff = Integer.MAX_VALUE;

        final List<Integer> sortedInts = Arrays
                .stream(arr)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        for (int i = k - 1; i < sortedInts.size(); i++) {
            final int diff = sortedInts.get(i) - sortedInts.get(i - k + 1);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
