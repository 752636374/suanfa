package 牛客网.二期.yaoheng.class_06;

/**
 * 测试方法：在main方法中，我们定义了一个卡牌数组cards，然后调用cardsInLine方法计算先手玩家能够获得的最大分数，并将结果打印输出。
 * 使用场景：该算法适用于两个玩家轮流从一行排列的卡牌中选择，每次只能选择最左边或最右边的卡牌，目标是使得先手玩家获得的分数最大化。
 * 实现逻辑：我们使用动态规划的思想来解决该问题。创建一个二维数组dp，其中dp[i][j]表示当剩下的卡牌范围为i到j时，先手玩家能够获得的最大分数。初始化对角线上的元素为卡牌数组中的值。然后，我们从长度为2的范围开始，逐渐增加范围的长度，遍历所有可能的范围，计算先手玩家选择最左边或最右边的卡牌时能够获得的分数，并更新dp[i][j]的值。最后，返回dp[0][n-1]作为结果，即先手玩家能够获得的最大分数。
 * 复杂度：该算法的时间复杂度为O(n^2)，其中n为卡牌的数量。空间复杂度为O(n^2)，用于存储动态规划的中间结果。
 */
public class CardsInLine {
    public static void main(String[] args) {
        int[] cards = {1, 2, 3, 4, 5};
        int maxScore = cardsInLine(cards);
        System.out.println("先手玩家能够获得的最大分数为：" + maxScore);
    }

    public static int cardsInLine(int[] cards) {
        // 创建一个二维数组dp，用于存储最大得分
        int n = cards.length;
        int[][] dp = new int[n][n];

        // 初始化对角线上的元素，表示只有一张卡牌时的最大得分
        for (int i = 0; i < n; i++) {
            dp[i][i] = cards[i];
        }

        // 动态规划计算最大得分
        // len表示卡牌序列的长度
        for (int len = 2; len <= n; len++) {
            // i表示卡牌序列的起始位置，j表示卡牌序列的结束位置
            for (int start = 0; start <= n - len; start++) {
                int j = start + len - 1;

                // 根据状态转移方程计算dp[i][j]的值
                dp[start][j] = Math.max(cards[start] - dp[start + 1][j], cards[j] - dp[start][j - 1]);
            }
        }

        // 返回整个卡牌序列的最大得分
        return dp[0][n - 1];
    }

}
