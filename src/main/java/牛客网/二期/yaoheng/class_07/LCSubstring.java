package 牛客网.二期.yaoheng.class_07;

public class LCSubstring {
    public static String longestCommonSubstring(String text1, String text2) {
        int m = text1.length(); // 获取text1的长度
        int n = text2.length(); // 获取text2的长度
        int[][] dp = new int[m + 1][n + 1]; // 创建一个二维数组dp，用于保存最长公共子序列的长度
        int maxLength = 0; // 最长公共子序列的长度
        int endIndex = 0; // 最长公共子序列的结束索引

        for (int i = 1; i <= m; i++) { // 遍历text1中的字符
            for (int j = 1; j <= n; j++) { // 遍历text2中的字符
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { // 如果当前字符相等
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 更新dp数组中的值为左上角元素加1
                    if (dp[i][j] > maxLength) { // 如果当前长度大于最大长度
                        maxLength = dp[i][j]; // 更新最大长度
                        endIndex = i; // 更新最长公共子序列的结束索引
                    }
                }
            }
        }

        return text1.substring(endIndex - maxLength, endIndex); // 根据最长公共子序列的结束索引和长度，返回最长公共子序列
    }


    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "defsg";
        String length = longestCommonSubstring(str1, str2);
        System.out.println(length);

    }

}
