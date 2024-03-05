package 牛客网.二期.yaoheng.class_07;

public class PrintUtil {
    public static void printDp(int[][] dp, String source, String target) {
        source = " " + source;
        target = " " + target;
        String split = "  ";

        System.out.print(" " + split);
        for (int i = 0; i < dp[0].length; i++) {
            System.out.print(target.charAt(i) + split);
        }
        System.out.println();

        for (int i = 0; i < dp.length; i++) {
            System.out.print(source.charAt(i) + split);
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + split);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {


    }
}
