package ca.judacribz.week5day1_test;

import java.util.HashMap;
import java.util.Map;

public class Algorithms {

    private static int
            NUM_ALPHABET = 26,
            UPPERCASE_MOD = 2 * 'A',
            LOWERCASE_MOD = 2 * 'a';

    public static String encodeString(String str) {
        char ch;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            sb.append(
                    ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) ?
                            getEncodedChar(ch) :
                            ch
            );
        }

        return sb.toString();
    }

    private static char getEncodedChar(char ch) {
        return (char) (NUM_ALPHABET - 1 - ch +  (ch < 97 ? UPPERCASE_MOD : LOWERCASE_MOD));
    }

    public static Map<Character, Integer> getCharFrequency(String str) {
        Map<Character, Integer> alphaMap = getAlphaMap();
        char ch;

        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                alphaMap.put(ch, alphaMap.get(ch) + 1);
            }
        }

        return alphaMap;
    }

    private static Map<Character, Integer> getAlphaMap() {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, 0);
        }

        return map;
    }
}
