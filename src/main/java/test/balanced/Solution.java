package test.balanced;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'balancedOrNot' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY expressions
     *  2. INTEGER_ARRAY maxReplacements
     */

    public static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {
        final ArrayList<Integer> result = new ArrayList<>();

        final int[] leftOpened = { 0 };
        final int[] rightOpened = { 0 };

        for (int i = 0; i < expressions.size(); i++) {
            final String expression = expressions.get(i);
            final Integer maxReplacement = maxReplacements.get(i);
            leftOpened[0] = 0;
            rightOpened[0] = 0;

            expression
                    .chars()
                    .mapToObj(c -> (char) c)
                    .forEach(c -> {
                        if (c == '<') {
                            leftOpened[0]++;
                            return;
                        }

                        if (c == '>') {
                            if (leftOpened[0] > 0) {
                                leftOpened[0]--;
                                return;
                            }

                            rightOpened[0]++;
                        }
                    });

            if (leftOpened[0] > 0) {
                result.add(0);
                continue;
            }

            if (rightOpened[0] > maxReplacement) {
                result.add(0);
                continue;
            }
            
            result.add(1);
        }

        return result;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int expressionsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> expressions = IntStream.range(0, expressionsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int maxReplacementsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> maxReplacements = IntStream.range(0, maxReplacementsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.balancedOrNot(expressions, maxReplacements);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
