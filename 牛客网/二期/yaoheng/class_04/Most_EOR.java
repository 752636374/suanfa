package 牛客网.二期.yaoheng.class_04;

import java.util.HashMap;
import java.util.Map;

/**
 * 作用： Most_EOR方法的作用是计算给定数组中最多异或和为0的子数组的个数。
 * <p>
 * 应用场景： 该方法适用于解决与子数组异或和相关的问题。例如，可以用它来找到最多异或和为0的子数组、找到异或和为特定值的子数组等。它可以帮助我们分析数组中的子数组之间的异或关系。
 * <p>
 * 复杂度： 该方法的时间复杂度为O(n)，其中n是给定数组的长度。它需要遍历一次数组，并使用哈希表进行查找和更新操作。空间复杂度为O(n)，需要额外的空间存储哈希表和dp数组。
 * <p>
 * 优势：
 * <p>
 * 时间复杂度较低：该方法能够在一次遍历中解决问题，具有较低的时间复杂度。
 * 高效的空间利用：通过使用哈希表和dp数组，可以高效地存储和更新子数组的异或和和个数。
 * 劣势：
 * <p>
 * 依赖额外的空间：为了存储哈希表和dp数组，需要额外的空间。如果输入数组较大，可能会占用较多的内存。
 * 仅适用于特定问题：该方法适用于解决与子数组异或和相关的问题，但对于其他类型的问题可能不适用。因此，其适用范围受限。
 */
public class Most_EOR {
    public static int Most_EOR(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int xor = 0;  // 异或结果
        int ans = 0;  // 最多异或和为0的子数组个数
        int[] dp = new int[arr.length];  // 存储以每个位置结尾的子数组的最多异或和为0的个数

        Map<Integer, Integer> map = new HashMap<>();  // 存储异或结果及其最早出现的位置
        map.put(0, -1);  // 初始化异或结果为0的位置为-1

        for (int i = 0; i < arr.length; i++) {
            // 计算当前位置的异或结果
            xor ^= arr[i];

            // 如果map中已存在当前异或结果，更新dp数组
            if (map.containsKey(xor)) {
                int preIndex = map.get(xor);
                dp[i] = preIndex == -1 ? 1 : (dp[preIndex] + 1);
            }

            // 更新dp数组，取前一个位置的最大值
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }

            // 将当前异或结果和索引存入map
            map.put(xor, i);

            // 更新最大值
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int result = Most_EOR(arr);
        System.out.println("最多异或和为0的子数组个数：" + result);
    }

}
