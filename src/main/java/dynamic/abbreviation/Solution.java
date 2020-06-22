package dynamic.abbreviation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int iB = 0;
        char cB = b.charAt(iB);
        char lowerCandidate = ' ';

        for (int iA = 0; iA < a.length(); iA++) {
            final char cA = a.charAt(iA);
            if (cA == cB) {
                if (iB >= b.length() - 1) {
                    iB = b.length();
                    cB = ' ';
                    continue;
                }
                iB++;
                cB = b.charAt(iB);
                continue;
            }

            if (Character.isUpperCase(cA)) {
                if (cA == Character.toUpperCase(lowerCandidate)) {
                    lowerCandidate = ' ';
                    continue;
                }
                return "NO";
            }

            if (Character.toUpperCase(cA) != cB) {
                continue;
            }

            lowerCandidate = cA;
            if (iB >= b.length() - 1) {
                iB = b.length();
                cB = ' ';
                continue;
            }
            iB++;
            cB = b.charAt(iB);
        }

        return iB == b.length() ? "YES" : "NO";
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
