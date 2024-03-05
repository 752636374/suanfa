package 牛客网.二期.yaoheng.class_04;

import java.util.HashMap;
import java.util.Map;

/**
 * 作用：是计算给定数组中和为目标值的最长子数组的长度。
 * 该代码实现了一个方法findLongestSumSubArray，用于查找数组中具有给定目标和的最长子数组的长度。
 *
 * 优势：
 *
 * 时间复杂度为O(n)，其中n是数组的长度，具有较高的效率。
 * 使用了哈希表来记录累加和，可以通过一次遍历就找到最长子数组的长度。
 * 算法适用于处理包含负数的数组。
 * 劣势：
 *
 * 存在额外的空间复杂度，需要使用哈希表来存储累加和。
 * 不能找到具体的最长子数组，只能得到最长子数组的长度。
 * 使用场景：
 *
 * 在需要找到具有特定目标和的最长子数组长度的情况下，该算法是一种高效的解决方案。
 * 适用于处理包含正数、负数和零的数组。
 * 可以应用于数组相关的算法问题，例如子数组问题、滑动窗口问题等。
 */
public class LongestSumSubArrayLength {
    public static int findLongestSumSubArray(int[] arr, int targetSum) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxLength = 0;  // 最长子数组的长度
        int sum = 0;  // 当前子数组的和
        Map<Integer, Integer> sumMap = new HashMap<>();  // 存储子数组和及其最早出现的索引
        sumMap.put(0, -1);  // 初始化和为0的索引为-1

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // 计算当前子数组的和
            if (sumMap.containsKey(sum - targetSum)) {  // 如果存在和为目标值的子数组
                maxLength = Math.max(maxLength, i - sumMap.get(sum - targetSum));  // 更新最长子数组的长度
            }
            if (!sumMap.containsKey(sum)) {  // 如果当前和还没有出现过
                sumMap.put(sum, i);  // 将当前和及其索引存入map
            }
        }

        return maxLength;  // 返回最长子数组的长度
    }


    public static void main(String[] args) {
        int[] arr = {1, -1, 5, -2, 3};
        int targetSum = 3;
        int maxLength = findLongestSumSubArray(arr, targetSum);
        System.out.println("Maximum length of subarray with sum " + targetSum + ": " + maxLength);
    }
}
