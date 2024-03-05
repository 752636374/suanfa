package 牛客网.二期.yaoheng.class_07;

import 牛客网.二期.yaoheng.TimeNumUtils;

public class LCSubsequence2_yh {
    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "xyjfg";
        int length = longestCommonSubSequenceHelp(str1, str2);
        System.out.println(length);
        TimeNumUtils.end();
    }

    private static int longestCommonSubSequenceHelp(String str1, String str2) {
        return longestCommonSubSequence(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    private static int longestCommonSubSequence(String str1, String str2, int s1, int s2) {
        TimeNumUtils.inc();
        //判定索引
        if (s1 < 0 || s2 < 0) {
            return 0;
        }
        //判定字符
        if (str1.charAt(s1) == str2.charAt(s2)) {
            return longestCommonSubSequence(str1, str2, s1 - 1, s2 - 1) + 1;
        }

        //求下一级
        return Math.max(longestCommonSubSequence(str1, str2, s1 - 1, s2), longestCommonSubSequence(str1, str2, s1, s2 - 1));
    }
}
