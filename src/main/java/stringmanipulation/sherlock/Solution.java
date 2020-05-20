package stringmanipulation.sherlock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        final Map<Integer, Integer> cpToFreq = s
                .codePoints()
                .boxed()
                .collect(Collectors.toMap(cP -> cP, cP -> 1, Math::addExact));

        final Map<Integer, Integer> freqToOcc = cpToFreq
                .values()
                .stream()
                .collect(Collectors.toMap(freq -> freq, freq -> 1, Math::addExact));

        if (freqToOcc.size() == 1) {
            return "YES";
        }

        if (freqToOcc.size() > 2) {
            return "NO";
        }

        final Integer max = freqToOcc
                .keySet()
                .stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);

        final Integer min = freqToOcc
                .keySet()
                .stream()
                .min(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);

        if (min == 1) {
            final Integer minOcc = freqToOcc.get(min);
            if (minOcc == 1) {
                return "YES";
            }
        }

        if (max - 1 == min) {
            final Integer maxOcc = freqToOcc.get(max);
            if (maxOcc == 1) {
                return "YES";
            }
        }
        
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
