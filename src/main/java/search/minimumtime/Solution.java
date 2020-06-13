package search.minimumtime;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long minDays = Arrays
                .stream(machines)
                .min()
                .orElseThrow(IllegalArgumentException::new);

        final long maxDays = minDays * goal;
        return minTime(machines, goal, minDays, maxDays);
    }

    private static long minTime(final long[] machines, final long goal, final long minDays, final long maxDays) {
        final long halfDays = (minDays + maxDays) / 2L;
        final long itemsProduced = getItemsProduced(machines, halfDays);
        if (itemsProduced == goal) {
            return halfDays;
        }
        
        if (itemsProduced > goal) {
            return minTime(machines, goal, minDays, halfDays);
        }
        
        return minTime(machines, goal, halfDays, maxDays);
    }

    private static long getItemsProduced(final long[] machines, final long days) {
        long itemsProduced = 0L;
        for (final long machine : machines) {
            itemsProduced += days / machine;
        }
        return itemsProduced;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
