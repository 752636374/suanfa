package 牛客网.二期.yaoheng.class_06;

public class CardsInLine_yh {
    public static void main(String[] args) {
        int[] ins = new int[]{1, 2, 3, 4, 5};
        System.out.println(getMax(ins));
    }

    private static int getMax(int[] cards) {
        //设置存储中间数的数组
        int n = cards.length;
        int[][] dp = new int[n][n];
        //只剩下一个值的时候
        for (int i = 0; i < n; i++) {
            dp[i][i] = cards[i];
        }
        //遍历集合，并且设置数据
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int j = start + len - 1;
                dp[start][j] = Math.max(cards[start] - dp[start + 1][j], cards[j] - dp[start][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}
