package stackandqueue.minmaxriddle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
        final Map<Integer, Long> sizeToValueMap = createSizeToValueMap(arr);

        return convertSizeMapToResult(sizeToValueMap, arr.length);
    }

    private static long[] convertSizeMapToResult(final Map<Integer, Long> sizeToValueMap, final int maxWindowSize) {
        final TreeMap<Integer, Long> sortedSizeToValueMap = new TreeMap<>(sizeToValueMap);
        final long[] result = new long[maxWindowSize];

        final long[] previousValue = { Long.MIN_VALUE };
        sortedSizeToValueMap
                .descendingMap()
                .values()
                .removeIf(v -> {
                    previousValue[0] = Math.max(previousValue[0], v);
                    return v < previousValue[0];
                });

        for (int i = 1; i <= maxWindowSize; i++) {
            final Long value = sortedSizeToValueMap
                    .ceilingEntry(i)
                    .getValue();
            result[i - 1] = value;
        }

        return result;
    }

    private static Map<Integer, Long> createSizeToValueMap(final long[] arr) {
        final Map<Integer, Long> sizeToValueMap = new HashMap<>(arr.length);

        final Deque<Window> windows = new ArrayDeque<>();
        final Window firstWindow = new Window(arr[0], 0);
        windows.addLast(firstWindow);
        sizeToValueMap.put(1, arr[0]);

        for (int i = 1; i < arr.length; i++) {
            Window previousWindow = windows.peekLast();
            final long value = arr[i];

            if (previousWindow.value == value) {
                continue;
            }

            if (previousWindow.value < value) {
                final Window window = new Window(value, i);
                windows.addLast(window);
                continue;
            }

            int startPos = previousWindow.startPos;
            while (!windows.isEmpty() && previousWindow.value > value) {
                windows.removeLast();
                previousWindow.putInMap(sizeToValueMap, i);

                startPos = previousWindow.startPos;

                previousWindow = windows.peekLast();
            }

            if (windows.isEmpty() || previousWindow.value < value) {
                final Window window = new Window(value, startPos);
                windows.addLast(window);
            }

        }

        while (!windows.isEmpty()) {
            final Window window = windows.removeLast();
            window.putInMap(sizeToValueMap, arr.length);
        }

        return sizeToValueMap;
    }

    private static class Window {

        private final long value;
        private final int startPos;

        public Window(final long value, final int startPos) {
            this.value = value;
            this.startPos = startPos;
        }

        public void putInMap(final Map<Integer, Long> sizeToValueMap, final int endPos) {
            final int windowSize = endPos - startPos;
            sizeToValueMap.merge(windowSize, value, Math::max);
        }
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
