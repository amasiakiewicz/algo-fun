package dynamic.abbreviation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        final Set<Character> aUpperChars = a
                .codePoints()
                .mapToObj(c -> (char) c)
                .filter(Character::isUpperCase)
                .collect(Collectors.toSet());

        final CharacterInString bCharInString = CharacterInString.create(b);
        for (int iA = 0; iA < a.length(); iA++) {
            char aChar = a.charAt(iA);
            if (Character.isUpperCase(aChar)) {
                if (!bCharInString.isEqualTo(aChar)) {
                     return "NO";                   
                }
                
                bCharInString.nextChar();
                continue;
            }

            aChar = Character.toUpperCase(aChar);
            if (!bCharInString.isEqualTo(aChar)) {
                continue;
            }

            if (bCharInString.isPresentIn(aUpperChars)) {
                continue;
            }
            
            bCharInString.nextChar();
        }

        return bCharInString.hasEnded() ? "YES" : "NO";
    }
    
    private static class CharacterInString {
        private int index;
        private char character;
        private String string;

        private static CharacterInString create(final String string) {
            final int index = 0;
            final char character = string.charAt(index);
            
            return new CharacterInString(index, character, string);
        }

        private CharacterInString(final int index, final char character, final String string) {
            this.index = index;
            this.character = character;
            this.string = string;
        }

        private boolean isEqualTo(final char character) {
            return this.character == character;
        }

        private void nextChar() {
            if (index < string.length() - 1) {
                index++;
                character = string.charAt(index);
                return;
            }
            
            index = string.length();
            character = ' ';
        }

        public boolean isPresentIn(final Set<Character> aUpperChars) {
            return aUpperChars.contains(character);
        }

        public boolean hasEnded() {
            return index == string.length();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
