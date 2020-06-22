package dynamic.maxarraysum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        final int max = Arrays
                .stream(arr)
                .max()
                .orElseThrow(IllegalAccessError::new);

        if (max <= 0) {
            return max;
        }

        final List<Integer> elements = Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.toList());
        final List<IndElement> subset = new ArrayList<>();
        final HashMap<Integer, Integer> indToSumMap = new HashMap<>();

        maxSubsetSum(0, elements, subset, indToSumMap);

        return indToSumMap
                .values()
                .stream()
                .mapToInt(e -> e)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static void maxSubsetSum(
            int i, final List<Integer> elements, final List<IndElement> subset, final Map<Integer, Integer> indToSumMap
    ) {
        int lastAddedInd = Integer.MIN_VALUE;

        for (; i < elements.size(); i++) {
            if (indToSumMap.containsKey(i)) {
                final int element = indToSumMap.get(i);
                final IndElement indElement = new IndElement(i, element);
                subset.add(indElement);
                break;
            }
            
            final int element = elements.get(i);
            if (element <= 0) {
                continue;
            }

            if (i - 1 > lastAddedInd) {
                final IndElement indElement = new IndElement(i, element);
                subset.add(indElement);
                lastAddedInd = i;
                continue;
            }

            final List<IndElement> newSubset = new ArrayList<>(subset.subList(0, subset.size() - 1));
            maxSubsetSum(i, elements, newSubset, indToSumMap);
        }

        int intermediateSum = 0;
        for (int j = subset.size() - 1; j >= 0; j--) {
            final IndElement indElement = subset.get(j);
            intermediateSum += indElement.element;
            indToSumMap.merge(indElement.index, intermediateSum, Math::max);
        }

    }

    private static class IndElement {
        private final int index;
        private final int element;

        IndElement(final int index, final int element) {
            this.index = index;
            this.element = element;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
