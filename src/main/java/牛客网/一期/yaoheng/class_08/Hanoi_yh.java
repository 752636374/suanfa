package 牛客网.一期.yaoheng.class_08;

/**
 * 思路：
 * 1、只有一个盘子时，直接移动到目标
 * 2、有多个盘子，先将n-1个移动到辅助柱子，然后移动第n个到目标柱子，最后讲n-1个弄到目标柱子
 */
public class Hanoi_yh {

    public static void main(String[] args) {
        int n = 3;
        hanoi(n,'A','B','C');
    }

    private static void hanoi(int n,char from ,char to ,char tx) {
        if(n == 1){
            System.out.println("move disk " +n+" from "+from+ " to " +to );
        }else {
            hanoi(n-1,from,tx,to);
            System.out.println("move disk " +n+" from "+from+ " to " +to );
            hanoi(n-1,tx,to,from);
        }
    }
}
