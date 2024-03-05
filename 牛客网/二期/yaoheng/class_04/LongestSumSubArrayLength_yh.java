package 牛客网.二期.yaoheng.class_04;

import java.util.HashMap;
import java.util.Map;

public class LongestSumSubArrayLength_yh {
    public static void main(String[] args) {
        int ins[] = {1, 2, 3, - 1, 5, 7, -2, 4};
        int value = 9;
        int length = getLength(ins, value);
        System.out.println(length + ":" + value);
    }

    private static int getLength(int[] ins, int value) {
        //初始化最长长度
        int length = 0;
        int size = 0;

        //初始化结合
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        //遍历数组
        for (int i = 0; i < ins.length; i++) {
            size += ins[i];
            if (map.containsKey(size - value)) {
                length = Math.max(length, i - map.get(size - value));
            }
            if (!map.containsKey(size)) {
                map.put(size, i);
            }
        }

        return length;
    }
}
