package 牛客网.二期.teach.advanced_class_05;

public class Code_04_MaxHappy {

    /**
     * 计算最大的快乐值
     *
     * @param matrix 快乐值矩阵
     * @return 最大的快乐值
     */
    public static int maxHappy(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][2];
        boolean[] visited = new boolean[n];
        int root = findRoot(matrix);
        process(matrix, dp, visited, root);
        return Math.max(dp[root][0], dp[root][1]);
    }

    /**
     * 寻找根节点
     *
     * @param matrix 快乐值矩阵
     * @return 根节点的索引
     */
    private static int findRoot(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (i == matrix[i][0]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 递归处理快乐值矩阵
     *
     * @param matrix  快乐值矩阵
     * @param dp      动态规划数组
     * @param visited 访问标记数组
     * @param root    当前节点
     */
    private static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = matrix[root][1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == root && !visited[i]) {
                process(matrix, dp, visited, i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 8}, {1, 9}, {1, 10}};
        System.out.println(maxHappy(matrix));
    }
}
