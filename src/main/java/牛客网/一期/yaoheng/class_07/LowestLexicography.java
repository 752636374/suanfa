package 牛客网.一期.yaoheng.class_07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 实现原理：
 *
 * 首先，定义一个自定义的比较器LexicographicComparator，用于比较两个字符串的拼接结果的字典序。
 * 接下来，使用Arrays.sort()方法对字符串数组进行排序，排序时使用自定义的比较器进行比较。
 * 最后，将排序后的字符串数组按顺序拼接起来，得到最小字典序的拼接结果。
 * 时间复杂度：排序的时间复杂度为O(nlogn)，其中n是字符串数组的长度。拼接字符串的时间复杂度为O(n)，因此总时间复杂度为O(nlogn)。
 *
 * 空间复杂度：除了输入和输出的空间，算法的额外空间复杂度为O(1)，因为只使用了常数级别的额外空间。
 *
 * 这段代码是高效的，因为它使用了排序算法对字符串数组进行排序，然后直接拼接排序后的字符串数组，时间复杂度为O(nlogn)，其中n是字符串数组的长度。同时，算法的空间复杂度也很低，只需要常数级别的额外空间。
 */
public class LowestLexicography {
    public static String lowestLexicography(String[] words) {
        // 使用自定义的Comparator对字符串数组进行排序
        Arrays.sort(words, new LexicographicComparator());

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }

        return sb.toString();
    }

    // 自定义的Comparator，用于比较两个字符串的拼接结果的字典序
    static class LexicographicComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s1.compareTo(s2);
        }
    }

    public static void main(String[] args) {
        String[] words = {"abc", "de", "f"};
        String lowestLex = lowestLexicography(words);
        System.out.println("Lowest lexicographic order: " + lowestLex); // 输出 "abcdef"
    }
}
