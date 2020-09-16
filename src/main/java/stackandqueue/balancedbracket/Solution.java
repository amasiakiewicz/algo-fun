package stackandqueue.balancedbracket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Map<Character, Character> leftRightMap = new HashMap<>();
    static {
        leftRightMap.put('(', ')');
        leftRightMap.put('{', '}');
        leftRightMap.put('[', ']');
    }
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if (s.length() == 1) {
            return "NO";
        }
        
        final Deque<Character> charStack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (leftRightMap.containsKey(c)) {
                charStack.addLast(c);
                continue;
            }

            if (charStack.isEmpty()) {
                return "NO";
            }

            final char left = charStack.removeLast();
            final char right = leftRightMap.get(left);
            if (right != c) {
                return "NO";
            }
        }
        
        return charStack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
