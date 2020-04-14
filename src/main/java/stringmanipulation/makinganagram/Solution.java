package stringmanipulation.makinganagram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        final Map<Character, Integer> char2OccNrMap = new HashMap<>();

        a
                .codePoints()
                .mapToObj(i -> (char) i)
                .forEach(i -> char2OccNrMap.merge(i, 1, Math::addExact));
        
        b
                .codePoints()
                .mapToObj(i -> (char) i)
                .forEach(i -> char2OccNrMap.merge(i, -1, Math::addExact));

        return char2OccNrMap
                .values()
                .stream()
                .mapToInt(Math::abs)
                .sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
