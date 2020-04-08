package warmup.repeatedstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int nrOfLettersToConsider = (int) Math.min(s.length(), n);
        long result = getCountWithinIndex(s, nrOfLettersToConsider);
        
        if (n <= s.length()) {
            return result;
        }

        final long maxSubstrLength = Math.max(n, s.length());
        final long nrOfFullOccurrences = maxSubstrLength / s.length();
        result *= nrOfFullOccurrences;

        nrOfLettersToConsider = (int) (n % s.length());
        final long resultWithinLastPart = getCountWithinIndex(s, nrOfLettersToConsider);
        result += resultWithinLastPart;

        return result;
    }

    private static long getCountWithinIndex(String s, int nrOfLettersToConsider) {
        return s
                .substring(0, nrOfLettersToConsider)
                .chars()
                .mapToObj(i -> (char) i)
                .filter(c -> c == 'a')
                .count();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
