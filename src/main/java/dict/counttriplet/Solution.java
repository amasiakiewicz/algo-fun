package dict.counttriplet;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long triplets = 0L;

        final Map<Long, Set<Integer>> valueToIndexesMap = new HashMap<>(arr.size());
        IntStream
                .range(0, arr.size())
                .forEach(i -> {
                    final HashSet<Integer> indexes = new HashSet<>();
                    indexes.add(i);
                    valueToIndexesMap.merge(arr.get(i), indexes, (oldSet, newSet) -> {
                        oldSet.addAll(newSet);
                        return oldSet;
                    });
                });

        for (int i = 0; i < arr.size() - 2; i++) {
            final List<Long> subArr = arr.subList(i, arr.size());
            triplets += countTriplets(i, r, 3, arr, valueToIndexesMap);
        }

        return triplets;
    }

    private static long countTriplets(int currentIndex, long r, int i, List<Long> arr, Map<Long, Set<Integer>> valueToIndexesMap) {
        if (i == 1) {
            return 1L;
        }

        if (currentIndex >= arr.size()) {
            return 0L;
        }

        final Long firstElement = arr.get(currentIndex);
        final long nextElement = firstElement * r;

        final List<Long> nextElementSearchList = arr.subList(currentIndex + 1, arr.size());
        final Set<Integer> nextElementIndexes = valueToIndexesMap.getOrDefault(nextElement, new HashSet<>());
        return nextElementIndexes
                .stream()
                .filter(index -> index > currentIndex)
                .mapToLong(nextElementIndex -> {
                    final List<Long> subList = arr.subList(nextElementIndex, arr.size());
                    return countTriplets(nextElementIndex, r, i - 1, arr, valueToIndexesMap);
                })
                .sum();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
