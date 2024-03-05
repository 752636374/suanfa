package 牛客网.二期.yaoheng.class_07;

public class LIS_yh {
    public static void main(String[] args) {
        int[] ins = {10, 9, 2, 5, 3, 7, 101, 18};
        int num = lis(ins);
        System.out.println(num);
    }

    private static int lis(int[] ins) {
        //定义最大长度
        int max = 0;
        //缓存每个节点的长度
        int[] c = new int[ins.length];

        for (int i = 0; i < ins.length; i++) {
            c[i] = 1;
            for (int j = 0; j < i; j++) {
                if (ins[i] > ins[j]) {
                    c[i] = Math.max(c[i], c[j] + 1);
                }
            }
            max = Math.max(max, c[i]);
        }
        return max;

    }
}
