package 牛客网.一期.yaoheng.class_08;

/**
 * 实现逻辑和目的：
 *
 * 首先，我们获取矩阵的行数和列数，并创建一个与原始矩阵相同大小的二维数组dp，用于存储最小路径和。
 * 接下来，我们计算第一列和第一行的最小路径和。由于只能向下或向右移动，所以第一列和第一行的路径和只能通过一次累加得到。
 * 然后，我们使用动态规划的方法计算其他位置的最小路径和。对于每个位置(i, j)，最小路径和是从上方位置(i-1, j)和左方位置(i, j-1)中选择较小的路径和，再加上当前位置的值matrix[i][j]。
 * 最后，我们返回右下角位置的最小路径和，即dp[rows - 1][cols - 1]。
 * 时间复杂度：O(rows * cols)，其中rows是矩阵的行数，cols是矩阵的列数。我们需要遍历整个矩阵一次来计算最小路径和。
 *
 * 空间复杂度：O(rows * cols)，我们使用了一个与原始矩阵相同大小的二维数组dp来存储最小路径和。这个数组占用了额外的空间来存储中间结果。
 *
 * 实现目的：该算法的目的是找到从矩阵的左上角到右下角的最小路径和。通过使用动态规划的思想，我们可以将问题分解为子问题，并利用子问题的解来构建整体的最优解。这样，我们可以高效地计算出最小路径和，而不需要重复计算相同的子问题。
 */
public class MinPath {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int minPathSum = findMinPath(matrix);
        System.out.println("Minimum path sum: " + minPathSum);
    }

    public static int findMinPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols]; // 创建一个与原始矩阵相同大小的二维数组dp，用于存储最小路径和

        // 计算第一列的最小路径和
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        // 计算第一行的最小路径和
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // 计算其他位置的最小路径和
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }

        return dp[rows - 1][cols - 1]; // 返回右下角位置的最小路径和
    }
}
