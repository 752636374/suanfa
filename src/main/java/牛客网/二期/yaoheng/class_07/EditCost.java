package 牛客网.二期.yaoheng.class_07;

/**
 * minEditCost函数用于计算将字符串word1转换为字符串word2所需的最小编辑成本（Edit Cost）。编辑成本包括插入、删除和替换字符的操作，每个操作的成本均为1。
 * 实现逻辑：使用动态规划的方法来解决问题。定义一个二维数组dp，其中dp[i][j]表示将word1的前i个字符转换为word2的前j个字符所需的最小编辑成本。首先初始化第一行和第一列，表示将一个字符串转换为空串的成本。然后，从左上角开始遍历字符串word1和word2的所有字符，根据当前字符是否相等来更新dp数组。如果两个字符相等，则当前位置的最小编辑成本与左上角元素相同；如果两个字符不相等，则当前位置的最小编辑成本为左方、上方和左上角元素中的最小值加1。最后返回dp[m][n]，其中m和n分别是字符串word1和word2的长度。
 * 测试方法：在测试方法中，定义两个字符串word1和word2，调用minEditCost函数计算将word1转换为word2所需的最小编辑成本，并打印结果进行验证。
 **/
public class EditCost {
    public static int minEditCost(String source, String target) {
        int m = source.length();
        int n = target.length();
        int[][] dp = new int[m + 1][n + 1];

        // 初始化第一行和第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 动态规划计算编辑距离
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        PrintUtil.printDp(dp, source, target);
        return dp[m][n];
    }



    // 测试方法
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int editCost = minEditCost(word1, word2);
        System.out.println("Minimum edit cost: " + editCost); // Output: 5
    }
}
