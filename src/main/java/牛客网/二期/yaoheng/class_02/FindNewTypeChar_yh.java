package 牛客网.二期.yaoheng.class_02;

import java.util.HashMap;
import java.util.Map;

public class FindNewTypeChar_yh {
    public static void main(String[] args) {
        String str = "abdesdwss";
        char c = findFirstOnece(str);
        System.out.println(c);
    }

    private static Character findFirstOnece(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }
}
