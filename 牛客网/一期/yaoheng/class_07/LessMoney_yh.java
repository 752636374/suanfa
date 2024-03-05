package 牛客网.一期.yaoheng.class_07;

import java.util.Arrays;

public class LessMoney_yh {

    public static void main(String[] args) {
        int total = 32;
        int[] coins = {1, 5, 10, 20, 50};

        int num = minCoinsCount(total, coins);
        System.out.println(num);
    }

    private static int minCoinsCount(int money, int[] coins) {
        int count = 0;
        int index = coins.length - 1;
        Arrays.sort(coins);
        while (money > 0) {
            if (index < 0) {
                return -1;
            }
            //查询最大硬币
            if (money >= coins[index]) {
                money -= coins[index];
                count++;
            } else {
                index--;
            }
            //减少银币
        }
        return count;
    }
}
