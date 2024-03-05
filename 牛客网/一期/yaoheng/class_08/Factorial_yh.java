package 牛客网.一期.yaoheng.class_08;

public class Factorial_yh {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(factorial01(num));//递归
        System.out.println(factorial02(num));//非递归
    }

    private static int factorial02(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        for (int i = num - 1; i > 0; i--) {
            num = i * num;
        }
        return num;
    }

    private static int factorial01(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return num * factorial01(num - 1);
    }
}
