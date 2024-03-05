package 牛客网.二期.yaoheng.class_06;

/**
 * 应用场景：该算法用于计算组成给定金额的硬币组合方式的数量。例如，假设有不同面额的硬币，我们想要知道组成金额 X 的硬币组合方式的数量。
 *
 * 复杂度分析：
 *
 * 时间复杂度：该算法使用了两层循环，其中外层循环遍历硬币数组，内层循环遍历金额。因此，时间复杂度为 O(coins.length * amount)，其中 coins.length 是硬币数组的长度，amount 是给定的金额。
 * 空间复杂度：该算法使用了一个长度为 amount + 1 的动态规划数组 dp，因此，空间复杂度为 O(amount)。
 *
 * 实现逻辑：

 * 创建一个长度为 amount + 1 的动态规划数组 dp，其中 dp[i] 表示组成金额 i 的硬币组合方式的数量。
 * 初始化 dp[0] 为 1，表示组成金额为 0 的组合方式只有一种，即不选择任何硬币。
 * 对于每个硬币面额 coin，从 coin 开始遍历到 amount，更新 dp[i] 的值。具体更新方式为 dp[i] += dp[i - coin]，表示当前金额 i 的组合方式数量等于金额 i - coin 的组合方式数量加上选择硬币面额为 coin 后的组合方式数量。
 * 返回 dp[amount]，即组成给定金额的硬币组合方式的数量。
 */
public class CoinsWay {
    public static void main(String[] args) {
        CoinsWay coinsWay = new CoinsWay();

        // 测试方法
        int[] coins = {5, 15, 25,1};
        int amount = 15;
        int ways = coinsWay.countWays(amount, coins);
        System.out.println("组成金额 " + amount + " 的硬币组合方式数量为: " + ways);
    }

    public int countWays(int amount, int[] coins) {
        // 创建一个长度为amount+1的数组dp，用于存储组成金额i的方法数
        int[] dp = new int[amount + 1];
        // 初始化dp[0]为1，表示金额为0的方法数为1
        dp[0] = 1;

        // 遍历硬币数组
        for (int coin : coins) {
            // 从硬币面额开始遍历到目标金额
            for (int i = coin; i <= amount; i++) {
                // 更新dp[i]的值，累加使用当前硬币coin和使用之前硬币组成金额i-coin的方法数
                dp[i] += dp[i - coin];
            }
        }

        // 返回组成目标金额的方法数
        return dp[amount];
    }

}
