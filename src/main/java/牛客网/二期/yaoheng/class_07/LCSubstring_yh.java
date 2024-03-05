package 牛客网.二期.yaoheng.class_07;

public class LCSubstring_yh {

    public static void main(String[] args) {
        String s1 = "abiejdadl";
        String s2 = "abiejdadafa";
        String result = getLCSubString(s1, s2);
        System.out.println(result);

    }

    private static String getLCSubString(String s1, String s2) {
        //初始化值缓存数组
        Integer s1Len = s1.length();
        Integer s2Len = s2.length();
        int length = 0;
        int endIndex = 0;
        int[][] ins = new int[s1Len + 1][s2Len + 1];
        //遍历字符串
        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ins[i][j] = ins[i - 1][j - 1] + 1;
                    if(ins[i][j]>length){
                        endIndex = j;
                        length = ins[i][j];
                    }
                }
            }
        }
        return s2.substring(endIndex-length,endIndex);
    }
}
