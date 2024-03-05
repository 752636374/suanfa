package 牛客网.一期.yaoheng.class_08;

public class MinPath_yh {
    public static void main(String[] args) {
        //定义矩阵
        int[][] matrix = {
                {12, 3, 3},
                {2, 5, 6},
                {8, 2, 9}
        };
        int minPathSum = findMinPath(matrix);
        System.out.println(minPathSum);
    }

    private static int findMinPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //定义路径和数组
        int[][] path = new int[rows][cols];
        path[0][0] = matrix[0][0];

        //求第一行
        for (int i = 1; i < rows; i++) {
            path[0][i] = path[0][i - 1] + matrix[0][i];
        }

        //求第一列
        for (int i = 1; i < rows; i++) {
            path[i][0] = path[i - 1][0] + matrix[i][0];
        }

        //计算其他的点值
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + matrix[i][j];
            }
        }

        //返回(i-1,j-1)处数据
        return path[rows - 1][cols - 1];
    }
}
