package stringmanipulation.specialstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long result = 0;

        final Map<Integer, List<Range>> cToRanges = new HashMap<>();
        final Set<ComplexRange> complexRanges = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            final int c = s.codePointAt(i);

            final List<Range> ranges = new ArrayList<>();
            final Range range = new Range(i, i + 1);
            ranges.add(range);

            cToRanges.merge(c, ranges, (ranges1, ranges2) -> {
                final Range previousRange = ranges1.get(ranges1.size() - 1);
                final Range nextRange = ranges2.get(0);

                if (nextRange.begin == previousRange.end) {
                    previousRange.end = nextRange.end;
                    return ranges1;
                }

                if (nextRange.begin - 1 == previousRange.end) {
                    final ComplexRange complexRange = new ComplexRange(previousRange, nextRange);
                    complexRanges.add(complexRange);
                }

                ranges1.addAll(ranges2);
                return ranges1;
            });
        }

        result += cToRanges
                .values()
                .stream()
                .flatMap(Collection::stream)
                .mapToLong(Range::getCount)
                .sum();

        result += complexRanges
                .stream()
                .mapToLong(ComplexRange::getLength)
                .sum();

        return result;
    }

    private static class Range {
        private final int begin;
        private int end;

        private Range(final int begin, final int end) {
            this.begin = begin;
            this.end = end;
        }

        private long getCount() {
            final long length = getLength();
            return (length * (length + 1)) / 2;
        }

        private int getLength() {
            return end - begin;
        }

    }

    private static class ComplexRange {
        private final Range previousRange;
        private final Range nextRange;

        public ComplexRange(final Range previousRange, final Range nextRange) {
            this.previousRange = previousRange;
            this.nextRange = nextRange;
        }

        private int getLength() {
            final int previousRangeLength = previousRange.getLength();
            final int nextRangeLength = nextRange.getLength();

            return Math.min(previousRangeLength, nextRangeLength);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
