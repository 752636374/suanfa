package 牛客网.二期.yaoheng.class_04;

import java.util.HashMap;
import java.util.Map;

public class Most_EOR_yh {

    public static void main(String[] args) {
        int[] ins = {1, 2, 3, 5 - 1, 4};
        System.out.println(MOST_EOR(ins));
    }

    private static int MOST_EOR(int[] ins) {
        //初始化：存放异或结果，最大个数，异或结果及索引，
        int ax = 0;
        int num = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[ins.length];
        map.put(0, -1);

        for (int i = 0; i < ins.length; i++) {
            //求异或结果
            ax ^= ins[i];
            //判定是否存在
            if (map.containsKey(ax)) {
                int pre = map.get(ax);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            map.put(ax, i);
            //存放到索引中
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            //设置最大值
            num = dp[i];

        }
        return num;
    }
}
