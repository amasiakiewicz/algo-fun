package dict.frequency;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    // Complete the freqQuery function below.

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        final ArrayList<Integer> results = new ArrayList<>();

        final Map<Integer, Integer> valueToOccMap = new HashMap<>(queries.size());
        final Map<Integer, Integer> freqToOccMap = new HashMap<>(queries.size());
        
        queries.forEach(q -> {
            final Integer cmd = q.get(0);
            final Integer value = q.get(1);
            switch (cmd) {
                case 1:
                    insert(valueToOccMap, freqToOccMap, value);
                    break;
                case 2:
                    delete(valueToOccMap, freqToOccMap, value);
                    break;
                case 3:
                    Integer result = print(freqToOccMap, value);
                    results.add(result);
                    break;
            }
        });

        return results;
    }

    private static Integer print(final Map<Integer, Integer> freqToOccMap, final Integer freq) {
        final boolean containsFreq = freqToOccMap.containsKey(freq);

        return containsFreq ? 1 : 0;
    }

    private static void delete(final Map<Integer, Integer> valueToOccMap, final Map<Integer, Integer> freqToOccMap, final Integer value) {
        valueToOccMap.computeIfPresent(value, (key, freq) -> {
            freqToOccMap.computeIfPresent(freq, (freqKey, freqOcc) -> {
                freqOcc--;
                return freqOcc == 0 ? null : freqOcc;
            });
            
            freq--;
            if (freq == 0) {
                return null;
            } else {
                freqToOccMap.merge(freq, 1, Math::addExact);
                return freq;
            }
        });
    }

    private static void insert(final Map<Integer, Integer> valueToOccMap, final Map<Integer, Integer> freqToOccMap, final Integer value) {
        valueToOccMap.compute(value, (key, oldFreq) -> {
            freqToOccMap.computeIfPresent(oldFreq, (freqKey, freqOcc) -> {
                freqOcc--;
                return freqOcc == 0 ? null : freqOcc;
            });
            
            Integer freq = oldFreq == null ? 1 : oldFreq + 1; 

            freqToOccMap.merge(freq, 1, Math::addExact);
            
            return freq;
        });
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
