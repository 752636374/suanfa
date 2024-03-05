package 牛客网.二期.yaoheng.class_07;

import 牛客网.二期.yaoheng.TimeNumUtils;

/**
 * 应用场景：
 * 最长公共子序列（Longest Common Subsequence，简称LCS）问题是一个经典的动态规划问题，它在许多实际应用中都有广泛的应用，例如：
 * 文本相似度：LCS可以用于比较两段文本之间的相似度。通过计算两段文本的最长公共子序列的长度，可以评估它们之间的相似程度。
 * DNA序列比对：在生物信息学中，LCS被广泛应用于比对DNA序列、蛋白质序列等生物序列。通过找到两个序列之间的最长公共子序列，可以揭示它们之间的共同特征和进化关系。
 * 版本控制：在版本控制系统中，LCS被用于比较两个版本之间的差异，从而实现增量式的文件更新和合并。
 * 拼写检查和自动纠错：在拼写检查和自动纠错算法中，LCS可以用于找到输入单词与词典中最相似的单词，从而进行纠错和建议。
 * 基因组装：在基因组学中，LCS被用于将碎片化的DNA序列片段组装成完整的基因组。
 * 总之，LCS是一个非常有用的算法，它在字符串比较、文本处理、生物信息学等领域都有广泛的应用。
 */
public class LCSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(); // 字符串text1的长度
        int n = text2.length(); // 字符串text2的长度
        int[][] dp = new int[m + 1][n + 1]; // 创建一个二维数组dp，用于存储最长公共子序列的长度

        // 遍历text1和text2的所有字符，计算最长公共子序列的长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                TimeNumUtils.inc();
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { // 如果当前字符相等
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 最长公共子序列的长度加1
                } else { // 如果当前字符不相等
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 取前一个字符的最长公共子序列长度和当前字符的最长公共子序列长度的较大值
                }
            }
        }

        return dp[m][n]; // 返回最长公共子序列的长度
    }


    // 测试方法
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "defsg";
        int longestSubsequence = longestCommonSubsequence(text1, text2);
        System.out.println("Longest common subsequence: " + longestSubsequence); // Output: 3
        TimeNumUtils.end();
    }
}
