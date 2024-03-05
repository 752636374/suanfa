package 牛客网.一期.yaoheng.class_08;

/**
 * 采用动态规划求解
 */
public class Knapsack_yh {
    public static void main(String[] args) {


        // 创建一个整数数组 values，用于存储物品的价值
        int[] values = {6, 10, 12};

        // 创建一个整数数组 weights，用于存储物品的重量
        int[] weights = {1, 2, 3};

        //总重量
        int total = 5;

        //开始运算总价值
        int num = getMaxValue(weights, values, total);
        System.out.println(num);
    }

    private static int getMaxValue(int[] weights, int[] values, int capacity) {
        int l = weights.length;
        //创建背包价值数组
        int[][] w = new int[l + 1][capacity + 1];

        //分别求不同价值背包存放数量
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    //容量够
                    w[i][j] = Math.max(values[i - 1] + w[i - 1][j - weights[i - 1]]
                            , w[i - 1][j]);
                } else {
                    //容量不够
                    w[i][j] = w[i - 1][j];
                }
            }
        }
        return w[l][capacity];
    }
}
