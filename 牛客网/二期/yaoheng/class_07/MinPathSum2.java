package 牛客网.二期.yaoheng.class_07;

public class MinPathSum2 {
    public static int minPathSum(int[][] grid) {
        // 获取矩阵的行数
        int m = grid.length;
        // 获取矩阵的列数
        int n = grid[0].length;
        // 返回计算得到的最小路径和
        return calculateMinPathSum(grid, m - 1, n - 1);
    }


    /**
     * 计算从起点到给定位置的最小路径和
     *
     * @param grid 二维网格
     * @param i    行索引
     * @param j    列索引
     * @return 最小路径和
     */
    private static int calculateMinPathSum(int[][] grid, int i, int j) {
        // 如果i和j同时为0，返回当前位置的值
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        // 如果i为0，说明只能从左边的位置到达当前位置，返回左边位置的最小路径和加上当前位置的值
        if (i == 0) {
            return calculateMinPathSum(grid, i, j - 1) + grid[i][j];
        }
        // 如果j为0，说明只能从上方的位置到达当前位置，返回上方位置的最小路径和加上当前位置的值
        if (j == 0) {
            return calculateMinPathSum(grid, i - 1, j) + grid[i][j];
        }
        // 返回从上方位置和左边位置中的最小路径和加上当前位置的值
        return Math.min(calculateMinPathSum(grid, i - 1, j), calculateMinPathSum(grid, i, j - 1)) + grid[i][j];
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
