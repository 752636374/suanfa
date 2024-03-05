package 牛客网.一期.yaoheng.basic_class_01.type2;

import java.util.Arrays;

/**
 * 最大间隔
 * 思想：弄一个长度大于数据量的数组，保证最大的差值在两个桶之间
 */
public class a11MaxGap2 extends AbstractSort2 {
    @Override
    void mySort(int[] as) {

    }

    public static void main(String[] args) {
        a11MaxGap2 a11MaxGap2 = new a11MaxGap2();
        int i = 0;
        while (i++ < 1000 && a11MaxGap2.extracted()) {
            System.out.println(i);
        }
    }

    private boolean extracted() {

        int[] as = random(10, 10);
//        as = new int[]{0, 0, 2, 3, 3, 3, 4, 5, 5};
        int defalut = getDefaultV(as);
        int num = run(as);
        if (defalut == num) {
            return true;
        } else {
            print("数据", as);
            System.out.println("默认差值：" + defalut);
            System.out.println("我的差值：" + num);
            System.out.println("no");
            return false;
        }
    }

    private int getDefaultV(int[] as) {
        Arrays.sort(as);
        int value = 0;
        for (int i = 0; i < as.length - 1; i++) {
            value = value > (as[i + 1] - as[i]) ? value : (as[i + 1] - as[i]);
        }
        return value;
    }

    private int run(int[] as) {
        int min = as[0];
        int max = as[0];
        for (int i = 0; i < as.length; i++) {
            min = min < as[i] ? min : as[i];
            max = max > as[i] ? max : as[i];
        }

        int[] mins = new int[as.length + 1];
        int[] maxs = new int[as.length + 1];
        boolean[] hasV = new boolean[as.length + 1];
        int index;
        boolean flag = true;

        for (int i = 0; i < as.length; i++) {
            index = getIndex(as[i], min, max, as.length);
            mins[index] = hasV[index] ? Math.min(mins[index], as[i]) : as[i];
            maxs[index] = hasV[index] ? Math.max(maxs[index], as[i]) : as[i];
            hasV[index] = flag;
        }

        int tcV = 0;
        int maxValue = maxs[0];
        for (int i = 1; i <= as.length; i++) {
            if (hasV[i]) {
                tcV = Math.max(tcV, mins[i] - maxValue);
                maxValue = maxs[i];
            }
        }
        return tcV;
    }

    private int getIndex(int a, int min, int max, int length) {
        return (length * (a - min)) / (max - min);
    }

}
