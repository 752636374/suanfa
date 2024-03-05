package 牛客网.二期.yaoheng.class_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 目的： FindNewTypeChar算法的目的是在给定字符串中找到第一个只出现一次的字符。
 *
 * 时间复杂度： 该算法的时间复杂度为O(n)，其中n是输入字符串的长度。算法需要遍历字符串两次，但由于字符集是有限的，因此遍历次数不会超过字符集的大小。
 *
 * 空间复杂度： 该算法的空间复杂度为O(k)，其中k是字符集的大小。算法使用了一个HashMap来统计字符出现次数，最坏情况下需要存储字符集中的所有字符。
 *
 * 注释： 在代码中，首先对输入字符串进行非空检查。然后使用HashMap来统计字符串中每个字符的出现次数。接着遍历字符串找到第一个出现次数为1的字符，并返回该字符。如果没有找到满足条件的字符，则抛出异常。
 *
 * 优劣势：
 *
 * 优势：该算法简单易懂，时间复杂度较低，能够快速找到第一个只出现一次的字符。
 * 劣势：该算法使用了额外的空间来存储字符出现次数，当字符集较大时，空间复杂度可能较高。另外，该算法只能找到第一个出现次数为1的字符，如果需要找到所有满足条件的字符，则需要进行一些修改。
 */
public class FindNewTypeChar {
    public static char findNewTypeChar(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        Map<Character, Integer> charCount = new HashMap<>();

        // 统计字符出现次数
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // 找到第一个出现次数为1的字符
        for (char c : str.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        throw new IllegalArgumentException("No new type character found.");
    }

    public static void main(String[] args) {
        String input = "abacddbe";
        char result = findNewTypeChar(input);
        System.out.println("New type character: " + result);
    }
}
