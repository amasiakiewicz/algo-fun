package test.firstocc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'firstOccurrence' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING x
     */

    public static int firstOccurrence(String s, String x) {
        if (x.length() > s.length()) {
            return -1;
        }

        if (!x.contains("*")) {
            return s.indexOf(x);
        }

        int xInd = 0;
        int result = -1;

        for (int i = 0; i < s.length(); i++) {
            final char sChar = s.charAt(i);

            if (xInd == x.length()) {
                return result;
            }

            final char xChar = x.charAt(xInd);

            if (xChar == '*') {
                xInd++;
                continue;
            }

            if (sChar != xChar) {
                xInd = 0;
                result = -1;
                continue;
            }

            xInd++;
            if (result == -1) {
                result = i;
            }
        }

        if (xInd != x.length()) {
            return -1;
        }

        return result;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String x = bufferedReader.readLine();

        int result = Result.firstOccurrence(s, x);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
