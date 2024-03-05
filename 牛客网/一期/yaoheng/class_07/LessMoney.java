package 牛客网.一期.yaoheng.class_07;

import java.util.Arrays;

/**
 * "lessMoney"算法是一个经典的贪心算法，用于将总金额拆分成最少的面额来支付。
 * 假设有一个总金额为total，以及一组面额数组coins，目标是用最少的硬币数量来凑出总金额。
 */
public class LessMoney {
    public static int minCoins(int total, int[] coins) {
        Arrays.sort(coins); // 将面额数组按升序排序
        int count = 0; // 记录使用的硬币数量
        int index = coins.length - 1; // 从最大面额开始

        while (total > 0) {
            if (index < 0) {
                // 如果所有面额都尝试完了，但是总金额仍然大于0，则无法凑出总金额
                return -1;
            }
            if (total >= coins[index]) {
                // 如果总金额大于等于当前面额，则使用该面额的硬币
                total -= coins[index];
                count++;
            } else {
                // 如果总金额小于当前面额，则尝试下一个更小的面额
                index--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int total = 63;
        int[] coins = {1, 5, 10, 20, 50}; // 面额数组

        int minCoinCount = minCoins(total, coins);

        if (minCoinCount == -1) {
            System.out.println("无法凑出总金额");
        } else {
            System.out.println("最少需要" + minCoinCount + "个硬币");
        }
    }
}
