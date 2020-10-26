package test.profit;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'stockPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stocksProfit
     *  2. LONG_INTEGER target
     */

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        if (target == 0) {
            final List<Integer> zeroProfits = stocksProfit
                    .stream()
                    .filter(p -> p.equals(0))
                    .collect(toList());
            return zeroProfits.size() >= 2 ? 1 : 0;
        }

        final Set<Pair> pairs = new HashSet<>();

        final Map<Integer, List<Integer>> profitToIndMap = new HashMap<>();

        for (int i = 0; i < stocksProfit.size(); i++) {
            final Integer profit = stocksProfit.get(i);
            final List<Integer> inds = new ArrayList<>();
            inds.add(i);
            profitToIndMap.merge(profit, inds, (oldInds, newInds) -> {
                oldInds.addAll(newInds);
                return oldInds;
            });
        }

        for (int i = 0; i < stocksProfit.size(); i++) {
            final int profit = stocksProfit.get(i);
            final int searchedProfit = (int) (target - (long) profit);
            if (!profitToIndMap.containsKey(searchedProfit)) {
                continue;
            }

            final int currentInd = i;
            final boolean foundProfit = profitToIndMap
                    .get(searchedProfit)
                    .stream()
                    .anyMatch(savedInd -> !savedInd.equals(currentInd));

            if (!foundProfit) {
                continue;
            }

            final int leftProfit = Math.min(profit, searchedProfit);
            final int rightProfit = Math.max(profit, searchedProfit);

            final Pair pair = new Pair(leftProfit, rightProfit);
            pairs.add(pair);
        }

        return pairs.size();
    }

    private static class Pair {

        private int leftProfit;
        private int rightProfit;

        Pair(final int leftProfit, final int rightProfit) {
            this.leftProfit = leftProfit;
            this.rightProfit = rightProfit;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Pair pair = (Pair) o;

            if (leftProfit != pair.leftProfit) return false;
            return rightProfit == pair.rightProfit;
        }

        @Override
        public int hashCode() {
            int result = leftProfit;
            result = 31 * result + rightProfit;
            return result;
        }
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stocksProfitCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> stocksProfit = IntStream.range(0, stocksProfitCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long target = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.stockPairs(stocksProfit, target);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
