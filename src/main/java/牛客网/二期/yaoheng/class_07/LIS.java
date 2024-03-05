package 牛客网.二期.yaoheng.class_07;

/**
 * 测试方法： 在main方法中，我们定义了一个测试数组nums，并调用lengthOfLIS方法来计算最长递增子序列的长度。然后将结果打印输出。
 *
 * 复杂度： 该实现使用了动态规划的思想，时间复杂度为O(n^2)，其中n是数组的长度。空间复杂度为O(n)，用来存储中间结果的动态规划数组。
 *
 * 应用场景： 最长递增子序列是一类常见的问题，可以用于解决一些具体的应用场景，例如：在一组数字中找到最长递增的连续子序列、在一组字符串中找到最长递增的子序列等。这个问题在排序、搜索和优化等领域都有广泛的应用。
 */
public class LIS {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length; // 数组长度
        int[] dp = new int[n]; // dp数组用于记录以当前元素结尾的最长递增子序列的长度
        int maxLength = 0; // 最长递增子序列的长度

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 初始化为1，因为每个元素本身可以构成一个长度为1的递增子序列
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 如果当前元素大于前面的某个元素
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 更新dp[i]为当前最大的递增子序列长度
                }
            }
            maxLength = Math.max(maxLength, dp[i]); // 更新最长递增子序列的长度
        }

        return maxLength; // 返回最长递增子序列的长度
    }


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lisLength = lengthOfLIS(nums);
        System.out.println("Length of LIS: " + lisLength);
    }
}
