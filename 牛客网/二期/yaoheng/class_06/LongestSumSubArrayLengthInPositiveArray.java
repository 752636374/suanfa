package 牛客网.二期.yaoheng.class_06;

/**
 * 复杂度：
 * <p>
 * 时间复杂度：该算法的时间复杂度为 O(n)，其中 n 是数组的长度。它使用了双指针技术，在一次遍历中找到了最长和为目标和的子数组的长度。
 * 空间复杂度：该算法的空间复杂度为 O(1)，只使用了常量级别的额外空间。
 * 适用场景： 该算法适用于正数数组，并且可以用于找到和为给定目标和的最长子数组的长度。它可以用于解决一些子数组和相关的问题，例如找到最长连续递增子数组的长度等。请注意，该算法要求数组中的元素必须为正数，因为它利用了正数的特性来计算子数组的和。
 */
public class LongestSumSubArrayLengthInPositiveArray {
    public static int findLongestSumSubArrayLength(int[] arr, int targetSum) {
        int length = arr.length;  // 获取数组长度
        int maxLength = 0;  // 最长子数组长度
        int currentSum = 0;  // 当前子数组的和
        int start = 0;  // 子数组的起始位置

        for (int end = 0; end < length; end++) {  // 遍历数组
            currentSum += arr[end];  // 将当前元素加到当前子数组的和中

            while (currentSum > targetSum) {  // 如果当前子数组的和大于目标和
                currentSum -= arr[start];  // 从当前子数组的和中减去起始位置的元素
                start++;  // 起始位置右移一位
            }

            if (currentSum == targetSum) {  // 如果当前子数组的和等于目标和
                int subArrayLength = end - start + 1;  // 计算子数组的长度
                maxLength = Math.max(maxLength, subArrayLength);  // 更新最长子数组长度
            }
        }

        return maxLength;  // 返回最长子数组长度
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int targetSum = 9;

        int maxLength = findLongestSumSubArrayLength(arr, targetSum);
        System.out.println("Max length of subarray with sum " + targetSum + ": " + maxLength);
    }
}
