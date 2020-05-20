package stringmanipulation.specialstring;

import org.apache.commons.lang3.text.StrBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long result = s.length();

        for (int l = 2; l <= s.length(); l++) {
            for (int ind = 0; ind <= s.length() - l; ind++) {
                final String candidate = s.substring(ind, ind + l);
                boolean isSpecialStr = isSpecialStr(candidate);
                if (isSpecialStr) {
                    result++;
                }
            }
        }
        
        return result;
    }

    private static boolean isSpecialStr(final String candidate) {
        if (candidate.length() == 0 || candidate.length() == 1) {
            return true;
        }

        if (candidate.length() % 2 == 0) {
            final long distinctCount = candidate
                    .codePoints()
                    .distinct()
                    .count();
            return distinctCount == 1;
        }

        if (candidate.length() % 2 != 0) {
            final int middleInd = candidate.length() / 2;
            final String candidateWithoutMiddle = new StrBuilder(candidate)
                    .deleteCharAt(middleInd)
                    .toString();
            return isSpecialStr(candidateWithoutMiddle);
        }
        
        return false;
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
