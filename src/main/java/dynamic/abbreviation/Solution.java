package dynamic.abbreviation;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toUpperCase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        boolean[][] dp = new boolean[1011][1011];
        dp[0][0] = true;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (dp[i][j]) {
                    final char ac = a.charAt(i);
                    final char aUpperC = toUpperCase(ac);

                    if (j < b.length() && aUpperC == b.charAt(j)) {
                        dp[i + 1][j + 1] = true;
                    }
                    if (!isUpperCase(ac)) {
                        dp[i + 1][j] = true;
                    }
                }
            }
        }

        return (dp[a.length()][b.length()]) ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
