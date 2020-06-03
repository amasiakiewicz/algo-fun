package search.triple;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        final long[] result = { 0L };
        
        final List<Element> aElements = Arrays
                .stream(a)
                .distinct()
                .mapToObj(i -> new Element(i, "a"))
                .collect(Collectors.toList());
        final List<Element> bElements = Arrays
                .stream(b)
                .distinct()
                .mapToObj(i -> new Element(i, "b"))
                .collect(Collectors.toList());
        final List<Element> cElements = Arrays
                .stream(c)
                .distinct()
                .mapToObj(i -> new Element(i, "c"))
                .collect(Collectors.toList());

        final long[] aCount = { 0L };
        final long[] cCount = { 0L };
        
        Stream
                .of(aElements, bElements, cElements)
                .flatMap(Collection::stream)
                .sorted()
                .forEach(e -> {
                    if ("a".equals(e.source)) {
                        aCount[0]++;
                        return;
                    }

                    if ("c".equals(e.source)) {
                        cCount[0]++;
                        return;
                    }
                    
                    result[0] += aCount[0] * cCount[0];
                });

        return result[0];
    }
    
    private static class Element implements Comparable<Element> {
        private final int value;
        private final String source;

        private Element(final int value, final String source) {
            this.value = value;
            this.source = source;
        }

        @Override
        public int compareTo(final Element o) {
            final int valueCompare = Integer.compare(this.value, o.value);
            if (valueCompare != 0) {
                return valueCompare;
            }

            if ("b".equals(this.source)) {
                return 1;
            }

            if ("b".equals(o.source)) {
                return -1;
            }
            
            return 0;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
