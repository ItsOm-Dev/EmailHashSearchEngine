package emailsearchengine;

import java.util.*;

public class CharEncoder {
    private static final Map<Character, String> charToCode = new HashMap<>();
    private static final Map<String, Character> codeToChar = new HashMap<>();

    static {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@._";
        for (int i = 0; i < chars.length(); i++) {
            String code = String.format("%02d", i);
            char c = chars.charAt(i);
            charToCode.put(c, code);
            codeToChar.put(code, c);
        }
    }

    public static String encode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(charToCode.getOrDefault(c, "??"));
        }
        return sb.toString();
    }

    public static String decode(String encoded) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encoded.length(); i += 2) {
            String code = encoded.substring(i, i + 2);
            sb.append(codeToChar.getOrDefault(code, '?'));
        }
        return sb.toString();
    }
}
