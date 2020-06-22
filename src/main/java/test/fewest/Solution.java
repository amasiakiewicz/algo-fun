package test.fewest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'fewestCoins' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING coins as parameter.
     */

    public static int fewestCoins(String coins) {
        final Set<Character> allChars = coins
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        int result = Integer.MAX_VALUE;

        for (int begining = 0; begining < coins.length(); begining++) {
            final HashSet<Character> newChars = new HashSet<>(allChars);
            int i = begining;
            while (!newChars.isEmpty() && i < coins.length()) {
                final char c = coins.charAt(i);
                newChars.remove(c);
                i++;
            }
            if (newChars.isEmpty()) {
                result = Math.min(result, i - begining);
            }
        }

        return result;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String coins = bufferedReader.readLine();

        int result = Result.fewestCoins(coins);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
