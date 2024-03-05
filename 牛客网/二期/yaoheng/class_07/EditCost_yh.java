package 牛客网.二期.yaoheng.class_07;

public class EditCost_yh {
    public static void main(String[] args) {
        String s1 = "abetsg";
        String s2 = "gjidiw";

        Integer length = editCost(s1, s2);
        System.out.println(length);
    }

    private static Integer editCost(String s1, String s2) {
        int row = s1.length();
        int col = s2.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= col; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        PrintUtil.printDp(dp, s1, s2);

        return dp[row][col];
    }
}
