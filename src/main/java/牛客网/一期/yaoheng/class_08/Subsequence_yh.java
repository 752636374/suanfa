package 牛客网.一期.yaoheng.class_08;


public class Subsequence_yh {
    public static void main(String[] args) {
        printAllSubsequence("abc");
    }

    private static void printAllSubsequence(String abc) {
        help(abc.toCharArray(), "", 0);
    }

    private static void help(char[] chars, String s, int i) {
        if (i == chars.length) {
            System.out.println(s);
            return;
        }
        help(chars, s, i + 1);
        help(chars, s + chars[i], i + 1);
    }
}
