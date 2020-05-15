package sorting.fraudulent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;

        
        for (int i = d; i < expenditure.length; i++) {
            int begin = i - d;
            int end = i - 1;
            
            final double middle = (begin + end) / 2.0;
            final int leftMiddle = (int) Math.floor(middle);
            int rightMiddle = (int) Math.ceil(middle);
            if (rightMiddle == d) {
                rightMiddle = leftMiddle;
            }

            final double median = (expenditure[leftMiddle] + expenditure[rightMiddle]) / 2.0;
            if ((double) expenditure[i] >= 2.0 * median) {
                result++;
            }

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
