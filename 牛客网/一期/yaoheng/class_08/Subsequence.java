package 牛客网.一期.yaoheng.class_08;

/**
 * 实现原理：
 * Subsequence算法用于生成给定字符串的所有子序列。一个字符串的子序列是从原始字符串中选择任意数量的字符，但是保持它们在原始字符串中的相对顺序不变。
 *
 * 实现步骤：
 * 1. 创建一个递归函数，用于生成所有子序列。
 * 2. 在递归函数中，终止条件是当前字符索引等于字符串的长度，此时打印当前生成的子序列并返回。
 * 3. 在递归函数中，分别调用两次递归，一次是不选择当前字符，另一次是选择当前字符。递归调用时，更新当前生成的子序列和字符索引。
 * 4. 在主函数中，调用递归函数来生成并打印给定字符串的所有子序列。
 *
 * 优劣势：
 * 优势：
 * - 算法简单易懂，易于实现。
 * - 可以生成给定字符串的所有子序列，包括空字符串。
 *
 * 劣势：
 * - 子序列数量随字符串长度指数级增长，对于较长的字符串可能会占用较多的时间和空间。
 *
 * 时间复杂度：O(2^n)，其中n是字符串的长度。每个字符都有两种状态：选择或不选择，因此总共有2^n个子序列。
 *
 * 空间复杂度：O(n)，递归调用的最大深度为字符串的长度n。
 */
public class Subsequence {
    /**
     * 打印给定字符串的所有子序列
     *
     * @param str 给定的字符串
     */
    public static void printAllSubsequences(String str) {
        helper(str, "", 0);
    }

    /**
     * 递归辅助函数，用于生成所有子序列
     *
     * @param str     给定的字符串
     * @param current 当前生成的子序列
     * @param index   当前字符的索引
     */
    private static void helper(String str, String current, int index) {
        if (index == str.length()) {
            System.out.println(current);
            return;
        }
        helper(str, current, index + 1); // 不选择当前字符
        helper(str, current + str.charAt(index), index + 1); // 选择当前字符
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllSubsequences(str);
    }
}
