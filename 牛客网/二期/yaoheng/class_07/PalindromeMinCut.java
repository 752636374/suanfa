package 牛客网.二期.yaoheng.class_07;

/**
 * PalindromeMinCut 方法可以用于解决需要将字符串划分为回文子串并找到最小切割数的问题。例如，可以用于解决回文串相关的字符串处理问题，如验证回文串、找到最长回文子串等。
 * <p>
 * 优劣势：
 * <p>
 * 优势：该方法使用动态规划的思想，能够高效地计算出将字符串划分为回文子串的最小切割数。
 * 劣势：实现稍微复杂一些，需要额外的空间来保存中间结果。
 * 时间复杂度：
 * <p>
 * PalindromeMinCut 方法的时间复杂度为 O(n^2)，其中 n 是字符串的长度。这是因为需要遍历每个子串并检查是否是回文串，共需要 O(n^2) 的时间。
 */
public class PalindromeMinCut {
    /**h
     * PalindromeMinCut 的实现思路可以分为以下几个步骤：
     * <p>
     * 初始化：创建一个长度为 n 的一维数组 dp，其中 dp[i] 表示前 i 个字符的最小切割数。
     * 初始化回文串判断数组：创建一个二维数组 isPalindrome，其中 isPalindrome[i][j] 表示从第 i 个字符到第 j 个字符是否为回文串。
     * 初始化对角线上的元素为 true，即 isPalindrome[i][i] = true。
     * 初始化相邻字符的元素，即 isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1))。
     * 动态规划计算最小切割数：
     * 外层循环遍历字符串的每个字符，从左往右计算最小切割数。
     * 内层循环从起始位置到当前位置，判断是否存在回文子串，并更新最小切割数。
     * 如果从起始位置到当前位置的子串是回文串，则最小切割数为 0。
     * 否则，遍历子串的每个切割点，计算切割点左侧子串的最小切割数加上右侧子串为回文串时的最小切割数，取最小值作为当前位置的最小切割数。
     * 返回 dp[n-1]，即整个字符串的最小切割数。
     *
     * @param s
     * @return
     */
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];

        // 初始化单个字符为回文
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        // 判断相邻两个字符是否相等
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        // 动态规划，计算回文串的最小分割数
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        // 计算每个子串的最小分割数
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {
        PalindromeMinCut palindromeMinCut = new PalindromeMinCut();

        // 测试用例1: "aab"
        String s1 = "badarere";
        int expected1 = 1;
        int result1 = palindromeMinCut.minCut(s1);
        System.out.println(result1);

        // 测试用例2: "aabbcc"
        String s2 = "aabbcc";
        int expected2 = 2;
        int result2 = palindromeMinCut.minCut(s2);
        System.out.println(result2);
    }
}
