package 牛客网.二期.yaoheng.class_07;

public class MinPathSum {
    /**
     * 计算矩阵中从左上角到右下角的最小路径和
     * 适用场景：该方法适用于求解矩阵中从起点到终点的最小路径和的问题。
     * 实现逻辑：使用动态规划的思想，从左上角开始，依次计算每个位置的最小路径和。对于每个位置，只能从左边或上边到达，选择较小的路径和加上当前位置的值，更新当前位置的最小路径和。最后返回右下角位置的最小路径和即可。
     * 复杂度：假设矩阵的行数为m，列数为n，则时间复杂度为O(m*n)，空间复杂度为O(m*n)。
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length; // 矩阵的行数
        int n = grid[0].length; // 矩阵的列数

        // 创建一个与原矩阵大小相同的dp数组，用于保存每个位置的最小路径和
        int[][] dp = new int[m][n];

        // 初始化第一行和第一列的最小路径和
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 逐行逐列计算每个位置的最小路径和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 选择较小的路径和加上当前位置的值，更新当前位置的最小路径和
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // 返回右下角位置的最小路径和
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int result = minPathSum(grid);
        System.out.println("Minimum path sum: " + result);
    }

}
