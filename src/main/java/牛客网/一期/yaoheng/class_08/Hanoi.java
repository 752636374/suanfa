package 牛客网.一期.yaoheng.class_08;

/**
 * 实现思路：
 *
 * 当只有一个盘子时，直接将盘子从源柱子移动到目标柱子。
 * 当有多个盘子时，先将n-1个盘子从源柱子移动到辅助柱子，然后将第n个盘子从源柱子移动到目标柱子，最后将n-1个盘子从辅助柱子移动到目标柱子。
 * 时间复杂度：O(2^n) - 指数级别的复杂度，因为每个盘子都需要移动2^n-1次。
 *
 * 空间复杂度：O(n) - 递归调用的深度为n。
 *
 * 优势：汉诺塔问题的解法是经典的递归算法，实现简单，思路清晰。
 *
 * 劣势：随着盘子数量的增加，时间复杂度呈指数级增长，效率低下。对于大规模的盘子数量，可能需要较长的运行时间。
 */
public class Hanoi {
    /**
     * 使用递归实现汉诺塔问题
     * @param n 盘子的数量
     * @param from 起始柱子
     * @param to 目标柱子
     * @param aux 辅助柱子
     */
    public static void hanoi(int n, char from, char to, char aux) {
        num ++;
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
//            System.out.println("Move disk " + n + " from " + from + " to " + to);
        } else {
            hanoi(n - 1, from, aux, to);
            System.out.println("Move disk " + n + " from " + from + " to " + to);
            hanoi(n - 1, aux, to, from);
        }
    }

   static int num =0;
    public static void main(String[] args) {
        int n = 3; // 汉诺塔的盘子数量
        hanoi(n, 'A', 'C', 'B');
        System.out.println(num);
    }
}
