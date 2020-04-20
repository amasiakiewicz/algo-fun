package greedy.luckbalance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int result =
                Arrays
                        .stream(contests)
                        .filter(a -> a[1] == 0)
                        .mapToInt(a -> a[0])
                        .sum();

        final AtomicInteger nrOfLoses = new AtomicInteger();
        result +=
                Arrays
                        .stream(contests)
                        .filter(a -> a[1] == 1)
                        .sorted(Comparator.<int[]>comparingInt(a -> a[0]).reversed())
                        .peek(a -> nrOfLoses.getAndIncrement())
                        .mapToInt(a -> nrOfLoses.get() > k ? -a[0] : a[0])
                        .sum();

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
