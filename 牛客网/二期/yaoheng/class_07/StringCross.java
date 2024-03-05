package 牛客网.二期.yaoheng.class_07;

/**
 * 测试方法: main 方法中的示例代码演示了如何调用 isCross 方法来判断两个字符串是否交叉。你可以根据需要修改 s1 和 s2 的值进行测试。
 *
 * 应用场景: 该方法可以用于判断两个字符串是否可以通过交叉组合形成一个目标字符串。例如，可以用于验证密码重置链接的有效性，其中链接中的一部分来自于用户的用户名，另一部分是随机生成的令牌。
 *
 * 复杂度: 该算法的时间复杂度为 O(m * n)，其中 m 和 n 分别为两个字符串的长度。空间复杂度为 O(m * n)，用于存储动态规划的状态。
 */
public class StringCross {
    public static boolean isCross(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // 如果两个字符串的长度之和不等于第二个字符串的长度，则不可能交叉
        if (m + n != s2.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // 初始化第一行
        for (int i = 1; i <= n; i++) {
            if (s2.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // 初始化第一列
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s2.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // 计算交叉情况
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果前i-1个字符能够匹配，并且第i个字符和第i+j个字符相等
                // 或者如果前i个字符能够匹配，并且第i+j个字符和第j个字符相等
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s2.charAt(i + j - 1))
                        || (dp[i][j - 1] && s1.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }


        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "defg";
        System.out.println(isCross(s1, s2)); // 输出 false
    }
}
