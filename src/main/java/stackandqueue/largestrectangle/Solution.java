package stackandqueue.largestrectangle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        final Deque<Rectangle> rectangles = new ArrayDeque<>();
        final Rectangle firstRectangle = new Rectangle(h[0], 0);
        rectangles.addLast(firstRectangle);
        long largestSize = h[0];

        for (int i = 1; i < h.length; i++) {
            Rectangle previousRectangle = rectangles.peekLast();
            final int height = h[i];

            if (previousRectangle.height == height) {
                continue;
            }

            if (previousRectangle.height < height) {
                final Rectangle rectangle = new Rectangle(height, i);
                rectangles.addLast(rectangle);
                continue;
            }

            int startPos = previousRectangle.startPos;
            while (!rectangles.isEmpty() && previousRectangle.height > height) {
                rectangles.removeLast();

                long size = previousRectangle.countSize(i);
                largestSize = Math.max(largestSize, size);

                startPos = previousRectangle.startPos;

                previousRectangle = rectangles.peekLast();
            }

            if (rectangles.isEmpty() || previousRectangle.height < height) {
                final Rectangle rectangle = new Rectangle(height, startPos);
                rectangles.addLast(rectangle);
            }

        }

        while (!rectangles.isEmpty()) {
            final Rectangle rectangle = rectangles.removeLast();
            final long size = rectangle.countSize(h.length);
            largestSize = Math.max(largestSize, size);
        }

        return largestSize;
    }

    private static class Rectangle {

        private final int height;
        private final int startPos;

        public Rectangle(final int height, final int startPos) {
            this.height = height;
            this.startPos = startPos;
        }

        public long countSize(final int endPos) {
            return (long) height * (long) (endPos - startPos);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
