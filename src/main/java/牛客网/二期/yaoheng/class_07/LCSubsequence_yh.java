package 牛客网.二期.yaoheng.class_07;

public class LCSubsequence_yh {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "defsg";
        int length = largestSubsequence(str1, str2);
        System.out.println(length);

    }

    private static int largestSubsequence(String str1, String str2) {
        //初始化缓存数组，字符串长度
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        //遍历字符串
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[n][m];
    }
}
