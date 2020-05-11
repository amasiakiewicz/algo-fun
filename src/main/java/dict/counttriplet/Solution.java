package dict.counttriplet;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        if (arr.size() < 3) {
            return 0L;
        }

        final Map<Long, Long> singleToOccMap = new HashMap<>(arr.size());
        final Map<Long, Long> pairToOccMap = new HashMap<>(arr.size());
        final Map<Long, Long> tripletToOccMap = new HashMap<>(arr.size());
        
        arr.forEach(l -> {
            if (l % r != 0) {
                singleToOccMap.merge(l, 1L, Math::addExact);
                return;
            }
            
            final long previousL = l / r;
            
            final long previousLSingleOccurrences = singleToOccMap.getOrDefault(previousL, 0L);
            singleToOccMap.merge(l, 1L, Math::addExact);
            
            if (previousLSingleOccurrences == 0L) {
                return;
            }

            final long previousLPairOccurrences = pairToOccMap.getOrDefault(previousL, 0L);
            pairToOccMap.merge(l, previousLSingleOccurrences, Math::addExact);

            if (previousLPairOccurrences == 0) {
                return;
            }
            
            tripletToOccMap.merge(l, previousLPairOccurrences, Math::addExact);
        });

        return tripletToOccMap
                .values()
                .stream()
                .mapToLong(occ -> occ)
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
