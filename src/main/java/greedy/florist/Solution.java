package greedy.florist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int result = 0;
        final List<Integer> cList = Arrays
                .stream(c)
                .boxed()
                .sorted(reverseOrder())
                .collect(toList());

        int purchaseCount = 0;
        for (int i = 0; i < cList.size(); i += k) {
            final int finalPurchaseCount = purchaseCount;

            final int toIndex = Integer.min(i + k, cList.size());
            result += cList
                    .subList(i, toIndex)
                    .stream()
                    .mapToInt(p -> (finalPurchaseCount + 1) * p)
                    .sum();

            purchaseCount++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
