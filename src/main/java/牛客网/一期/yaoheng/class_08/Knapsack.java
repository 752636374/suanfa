package 牛客网.一期.yaoheng.class_08;

/**
 * 以下是一个Java实现的背包问题（Knapsack Problem）算法，使用动态规划方法解决。
 * 实现逻辑：
 * <p>
 * 首先，我们获取物品的数量 n，并创建一个二维数组 dp，用于存储最大总价值。
 * 我们使用双重循环来遍历每个物品和每个容量，从 1 到 n 和 1 到 capacity。
 * 对于每个物品，我们会判断其重量是否小于等于当前容量。如果是，我们可以选择将该物品放入背包或不放入背包。我们通过比较放入该物品和不放入该物品两种情况的总价值，选择总价值较大的方案。
 * 如果物品的重量大于当前容量，则无法放入背包，保持背包中的总价值不变。
 * 最后，我们返回 dp[n][capacity]，即最大总价值。
 * 该算法的时间复杂度为 O(n * capacity)，其中 n 是物品的数量，capacity 是背包的容量。我们需要遍历每个物品和每个容量来计算最大总价值。
 * <p>
 * 该算法的空间复杂度为 O(n * capacity)，我们使用了一个二维数组 dp 来存储最大总价值。这个数组占用了额外的空间来存储中间结果。
 * <p>
 * 我们选择使用动态规划方法来解决背包问题的原因是，动态规划利用子问题的最优解构建整体问题的最优解。通过将问题拆分为子问题，并存储子问题的解，我们可以避免重复计算，从而提高算法的效率。在背包问题中，我们通过填充一个二维数组 dp 来记录每个容量下的最大总价值，以便在计算过程中使用已解决的子问题的结果。这种自底向上的动态规划方法在背包问题中非常有效，并且时间复杂度相对较低，因此选择这种实现方式。
 */
public class Knapsack {
    public static void main(String[] args) {
        // 创建一个整数数组 values，用于存储物品的价值
        int[] values = {6, 10, 12};

        // 创建一个整数数组 weights，用于存储物品的重量
        int[] weights = {1, 2, 3};

        // 设置背包的容量为50
        int capacity = 5;

        // 调用 knapsack 方法，计算最大总价值
        int maxTotalValue = knapsack(values, weights, capacity);

        // 打印最大总价值
        System.out.println("Maximum total value: " + maxTotalValue);
    }

    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1]; // 创建一个二维数组dp，用于存储最大总价值

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    // 如果当前物品的重量小于等于剩余容量，则可以选择放入或不放入背包
                    dp[i][j] = Math.max(
                            values[i - 1] + dp[i - 1][j - weights[i - 1]],
                            dp[i - 1][j]);
                } else {
                    // 如果当前物品的重量大于剩余容量，则无法放入背包
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity]; // 返回最大总价值
    }
}
