package 牛客网.一期.yaoheng.basic_class_01.type2;

import java.util.Arrays;

/**
 * 1、生成随机数组
 * 2、默认排序
 * 3、交换数组
 * 4、比较数组
 * 5、交换数据
 */
public abstract class AbstractSort2 {

    /**
     * 随机数组
     *
     * @param max
     * @param length
     * @return
     */
    public int[] random(int max, int length) {
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = (int) (Math.random() * max);
        }
        return ints;
    }

    /**
     * 比较相等
     */
    public boolean isEqueals(int[] as, int[] bs) {
        if (as.length != bs.length) {
            return false;
        }
        for (int i = 0; i < as.length; i++) {
            if (as[i] != bs[i]) {
                return false;
            }
        }
        return true;
    }


    abstract void mySort(int[] as);

    /**
     * 默认排序
     *
     * @param as
     */
    public void defaultSort(int[] as) {
        Arrays.sort(as);
    }

    public int[] copy(int[] as) {
        int[] copy = new int[as.length];
        for (int i = 0; i < as.length; i++) {
            copy[i] = as[i];
        }
        return copy;
    }


    /**
     * 交换位置
     */
    public void swap(int[] as, int a1, int a2) {
        int a = as[a1];
        as[a1] = as[a2];
        as[a2] = a;
    }


    public void print(String name, int[] ai) {
        System.out.print(name + ":");
        for (int i = 0; i < ai.length; i++) {
            System.out.print(ai[i] + ",");
        }
    }


    public void start() {
        int max = 100;
        int length = 10;
        int[] old = random(max, length);

        int[] as1 = copy(old);
        int[] as2 = copy(old);

        defaultSort(as1);
        mySort(as2);

        if (!isEqueals(as1, as2)) {
            print("系统数组：", as1);
            print("自己数组：", as2);
            System.out.println("fuck");
        } else {
            System.out.println("nice");
            print("自己数组：", as2);
        }
    }


}
