package dict.sherlock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        final Map<String, SubstrOccurrence> substr2OccurrenceMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                final String substring = s.substring(i, j);
                final String sortedSubstring = substring
                        .chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();

                substr2OccurrenceMap.merge(sortedSubstring, new SubstrOccurrence(), SubstrOccurrence::addOccurrence);
            }
        }

        return substr2OccurrenceMap
                .values()
                .stream()
                .mapToInt(SubstrOccurrence::getNrOfPairs)
                .sum();
    }

    private static class SubstrOccurrence {

        private int nrOfSubstrings = 1;
        private int nrOfPairs = 0;

        SubstrOccurrence addOccurrence(SubstrOccurrence substrOccurrence) {
            nrOfPairs += nrOfSubstrings;
            nrOfSubstrings++;
            return this;
        }

        int getNrOfPairs() {
            return nrOfPairs;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
