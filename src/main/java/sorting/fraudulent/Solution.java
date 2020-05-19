package sorting.fraudulent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;

        final List<Integer> sortedTrailings = Arrays
                .stream(expenditure)
                .boxed()
                .limit(d)
                .sorted()
                .collect(Collectors.toList());

        final double middle = (d - 1) / 2.0;
        final int leftMiddleIndex = (int) Math.floor(middle);
        int rightMiddleIndex = (int) Math.ceil(middle);
        if (rightMiddleIndex == d) {
            rightMiddleIndex = leftMiddleIndex;
        }

        for (int i = d; i < expenditure.length; i++) {
            final Integer leftMiddle = sortedTrailings.get(leftMiddleIndex);
            final Integer rightMiddle = sortedTrailings.get(rightMiddleIndex);

            final double median = (leftMiddle + rightMiddle) / 2.0;
            final double doubleMedian = 2.0 * median;
            
            final int trailing = expenditure[i];
                       
            if (trailing > 0 && (double) trailing >= doubleMedian) {
                result++;
            }

            final int trailingToRemove = expenditure[i - d];
            final int trailingToRemoveIndex = Collections.binarySearch(sortedTrailings, trailingToRemove);
            sortedTrailings.remove(trailingToRemoveIndex);
            
            final int trailingIndex = Collections.binarySearch(sortedTrailings, trailing);
            final int insertionIndex = Math.abs(-trailingIndex - 1);
            sortedTrailings.add(insertionIndex, trailing);
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
