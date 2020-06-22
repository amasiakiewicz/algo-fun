package test.collision;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;



class Result {

    /*
     * Complete the 'collision' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY speed
     *  2. INTEGER pos
     */

    public static int collision(List<Integer> speed, int pos) {
        int result = 0;

        final Integer testSpeed = speed.get(pos);
        result += speed
                .subList(0, pos)
                .stream()
                .filter(s -> s > testSpeed)
                .count();

        result += speed
                .subList(pos + 1, speed.size())
                .stream()
                .filter(s -> s < testSpeed)
                .count();

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int speedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> speed = IntStream.range(0, speedCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int pos = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.collision(speed, pos);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
