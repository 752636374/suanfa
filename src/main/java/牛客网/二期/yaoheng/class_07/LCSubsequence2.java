package 牛客网.二期.yaoheng.class_07;

public class LCSubsequence2 {
    public static int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, text1.length()-1, text2.length()-1);
    }

    private static int longestCommonSubsequence(String text1, String text2, int m, int n) {
        // 如果其中一个字符串为空，则最长公共子序列的长度为0
        if (m < 0 || n < 0) {
            return 0;
        }

        // 如果当前字符相等，则最长公共子序列的长度为前一个字符的最长公共子序列长度加1
        if (text1.charAt(m) == text2.charAt(n)) {
            return longestCommonSubsequence(text1, text2, m-1, n-1) + 1;
        }

        // 如果当前字符不相等，则最长公共子序列的长度为两个字符串分别去掉最后一个字符后的最长公共子序列长度的较大值
        int length1 = longestCommonSubsequence(text1, text2, m-1, n);
        int length2 = longestCommonSubsequence(text1, text2, m, n-1);
        return Math.max(length1, length2);
    }
    // 测试方法
    public static void main(String[] args) {
        String text1 = "abcdefg";
        String text2 = "acefg";
        int longestSubsequence = longestCommonSubsequence(text1, text2);
        System.out.println("Longest common subsequence: " + longestSubsequence); // Output: 3
    }
}
