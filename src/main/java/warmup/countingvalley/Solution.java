package warmup.countingvalley;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static Map<Character, Integer> charToHeightMap = new HashMap<>();

    static {
        charToHeightMap.put('U', 1);
        charToHeightMap.put('D', -1);
    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        final int[] height = { 0 };
        final int[] result = { 0 };

        s.chars()
                .mapToObj(i -> (char) i)
                .map(c -> charToHeightMap.get(c))
                .forEach(h -> {
                    final int previousHeight = height[0]; 
                    height[0] += h;
                    
                    if (previousHeight < 0 && height[0] == 0) {
                        result[0]++;
                    }
                });

        return result[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
