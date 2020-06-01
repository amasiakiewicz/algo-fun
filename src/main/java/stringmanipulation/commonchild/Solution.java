package stringmanipulation.commonchild;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        if (s1.equals(s2)) {
            return s1.length();
        }

        final Map<Integer, List<Position>> cpToPosMap = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            final int cp = s2.codePointAt(i);

            final ArrayList<Position> positions = new ArrayList<>();
            final Position position = new Position(i);
            positions.add(position);

            cpToPosMap.merge(cp, positions, (positions1, positions2) -> {
                positions1.addAll(positions2);
                return positions1;
            });
        }

        final int[] result = { 0 };
        final int[] tmpResult = { 0 };
        final int[] previousPosition = { Integer.MAX_VALUE };

        s1
                .codePoints()
                .boxed()
                .forEach(cp -> {
                    int position = getPosition(cp, cpToPosMap);

                    if (position < 0) {
                        return;
                    }

                    if (position < previousPosition[0]) {
                        result[0] = Math.max(result[0], tmpResult[0]);
                        tmpResult[0] = 0;
                        reset(cpToPosMap, position);
                    }

                    tmpResult[0]++;
                    previousPosition[0] = position;
                });

        return Math.max(result[0], tmpResult[0]);
    }

    private static void reset(final Map<Integer, List<Position>> cpToPosMap, final int position) {
        cpToPosMap
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(p -> p.index != position)
                .forEach(Position::reset);
    }

    private static int getPosition(final Integer cp, final Map<Integer, List<Position>> cpToPosMap) {
        final List<Position> positions = cpToPosMap.getOrDefault(cp, new ArrayList<>());
        if (positions.isEmpty()) {
            return -1;
        }
        
        return positions
                .stream()
                .filter(p -> !p.used)
                .findFirst()
                .orElseGet(() -> new Position(-1))
                .use();
    }

    private static class Position {
        private int index;
        private boolean used;

        public Position(final int index) {
            this.index = index;
        }

        public int use() {
            used = true;
            return index;
        }

        public void reset() {
            used = false;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
