package 牛客网.二期.yaoheng.class_07;

public class PalindromeMinCut_yh {
    public static void main(String[] args) {
        String s1 = "badarere";
        int length = minCut(s1);
        System.out.println(length);
    }

    public static Integer minCut(String s) {
        //定义存储数组
        int length = s.length();
        boolean[][] ins = new boolean[length][length];
        int[] dp = new int[length];

        //设置存储数组初始化
        for (int i = 0; i < length; i++) {
            ins[i][i] = true;
        }
        for (int i = 0; i < length - 1; i++) {
            ins[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int lent = 3; lent <= length; lent++) {
            for (int i = 0; i <= length - lent; i++) {
                int j = i + lent - 1;
                ins[i][j] = ins[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }


        //设置割裂数组
        for (int i = 0; i < length; i++) {
            if (ins[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 0; j < i; j++) {
                    if (ins[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[length - 1];
    }
}
