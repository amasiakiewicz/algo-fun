package stackandqueue.minmaxriddle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        final long[] result = new long[arr.length];

        final Deque<Long> leftStack = Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        final Deque<Long> rightStack = new ArrayDeque<>(arr.length);

        result[0] = Arrays
                .stream(arr)
                .max()
                .getAsLong();

        Deque<Long> full = leftStack;
        Deque<Long> empty = rightStack;
        Deque<Long> tmp;

        int i = 1;
        long max, min;
        Long last, last_1;
        while (leftStack.size() != 1 && rightStack.size() != 1) {
            max = Long.MIN_VALUE;

            while (!full.isEmpty()) {
                last = full.removeLast();
                last_1 = full.peekLast();
                if (last_1 == null) {
                    continue;
                }

                min = Math.min(last, last_1);
                empty.addLast(min);
                max = Math.max(max, min);
            }

            result[i] = max;
            i++;

            tmp = full;
            full = empty;
            empty = tmp;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
