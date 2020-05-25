package stringmanipulation.commonchild;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        if (s1.equals(s2)) {
            return s1.length();
        }

        final List<Integer> s1Points = s1
                .codePoints()
                .boxed()
                .collect(toList());
        
        final List<Integer> s2Points = s2
                .codePoints()
                .boxed()
                .collect(toList());
        
        s1Points.retainAll(s2Points);

        return s1Points.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
