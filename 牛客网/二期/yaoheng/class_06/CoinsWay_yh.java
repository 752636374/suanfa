package 牛客网.二期.yaoheng.class_06;

public class CoinsWay_yh {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int num = 7;
        System.out.println(getCoinsWay(coins, num));
    }

    private static Integer getCoinsWay(int[] coins, int num) {
        //存放每个金额的组成方式
        int[] s = new int[num + 1];
        s[0] = 1;
        //遍历面值，设置金额
        for (int coin:coins) {
            for (int j = coin; j <= num; j++) {
                s[j] += s[j-coin];
            }
        }
        return s[num];
    }
}
