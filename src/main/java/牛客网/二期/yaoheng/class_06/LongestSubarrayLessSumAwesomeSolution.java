package 牛客网.二期.yaoheng.class_06;

/**
 * 应用场景： 该函数用于找到给定正数数组中的最长子数组，使得子数组的和小于给定的目标和。这可以用于解决一些问题，例如找到一个数组中和小于某个限制的最长连续子数组。
 *
 * 时间复杂度： 该算法的时间复杂度为O(n)，其中n是数组的长度。它使用了滑动窗口的方法，在一次遍历中完成计算，因此具有线性的时间复杂度。
 *
 * 空间复杂度： 该算法的空间复杂度为O(1)，因为它只使用了常量级的额外空间来存储一些变量。没有使用额外的数据结构或数组来存储中间结果。
 */
public class LongestSubarrayLessSumAwesomeSolution {
    public static int LongestSubarrayLessSumAwesomeSolution(int[] arr, int targetSum) {
        int maxLength = 0;  // 最大子数组长度
        int currentSum = 0;  // 当前子数组的和
        int start = 0;  // 子数组的起始位置

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];  // 将当前元素添加到子数组的和中

            while (currentSum > targetSum) {  // 如果当前子数组的和大于目标和
                currentSum -= arr[start];  // 从子数组的和中减去起始位置的元素
                start++;  // 更新起始位置，缩小子数组的范围
            }

            int subArrayLength = end - start + 1;  // 计算当前子数组的长度
            maxLength = Math.max(maxLength, subArrayLength);  // 更新最大子数组长度
        }

        return maxLength;  // 返回最大子数组长度
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int targetSum = 9;
        int maxLength = LongestSubarrayLessSumAwesomeSolution(arr, targetSum);
        System.out.println("MaxLength: " + maxLength);
    }
}
