package array.newyear;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        final String minimumBribesStr = minimumBribesStr(q);
        System.out.println(minimumBribesStr);
    }

    static String minimumBribesStr(int[] q) {
        int result = 0;
        TreeSet<Integer> diffPluses = new TreeSet<>();

        for (int i = 0; i < q.length; i++) {
            final int currentQ = q[i];
            diffPluses.add(currentQ);

            final int diff = currentQ - (i + 1);
            if (diff > 2) {
                return "Too chaotic";
            }

            if (diff == 1 || diff == 2) {
                result += diff;
                continue;
            }

            if (diff <= 0) {
                final long countBigger = diffPluses
                        .tailSet(currentQ)
                        .size() - 1;
                result += countBigger + diff;
            }
        }
        
        return Integer.toString(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
