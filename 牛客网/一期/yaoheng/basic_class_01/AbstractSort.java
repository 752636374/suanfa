package 牛客网.一期.yaoheng.basic_class_01;

import java.util.Arrays;

/**
 * @author yaoheng5
 * @Classname AbstractSort
 * @Description TODO
 * @date 2022/7/7 6:49
 * @Created by yaoheng5
 */
public abstract class AbstractSort {
    /**
     * 判定是否相等
     * @param array2
     * @param arrays1
     * @return
     */
    private boolean isEquals(int[] array2, int[] arrays1) {
        if (array2 == null && arrays1 == null) {
            return true;
        }
        if (arrays1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < arrays1.length; i++) {
            if (arrays1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印
     * @param name
     * @param arrays1
     */
    protected void print(String name,int[] arrays1) {
        System.out.print(name+":");
        for (int i = 0; i < arrays1.length; i++) {
            System.out.print(arrays1[i] + " ");
        }
        System.out.println();
    }

    /**
     * 排序
     * @param array2
     */
    private void defaultSort(int[] array2) {
        Arrays.sort(array2);
    }

    /**
     * 拷贝
     * @param arrays1
     * @return
     */
    protected int[] copy(int[] arrays1) {
        int[] arr = new int[arrays1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrays1[i];
        }
        return arr;
    }

    /**
     * 随机生成数组
     * @param maxLength
     * @param maxValue
     * @return
     */
    protected int[] random(int maxLength, int maxValue) {
        int[] arr = new int[maxLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (Math.random());
        }
        return arr;
    }

    /**
     * 排序
     * @param arr
     */
    protected abstract void sort(int[] arr);

    public void start() {
        //定义基本因子
        int times = 10000;
        int maxValue = 100;
        int maxLength = 10;
        boolean success = true;
        //循环比较
        for (int i = 0; i < times; i++) {
            //生成数组
            int[] arrays1 = random(maxLength, maxValue);
            //拷贝
            int array2[] = copy(arrays1);
            //排序1
            sort(arrays1);
            //排序2
            defaultSort(array2);

            //比较
            if (!isEquals(array2, arrays1)) {
                print("mySort",arrays1);
                print("deSort",array2);
                success = false;
                break;
            }

        }

        System.out.println(success ? "Nice!" : "fuck!");
        //输出排序前后
        //排序前
        int[] arrays1 = random(maxLength, maxValue);
        print("noSort",arrays1);
        sort(arrays1);
        print("mySrot",arrays1);
    }


    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    protected void swap(int[] arr, int i, int j) {
        int a = arr[i];
        arr[i]= arr[j];
        arr[j] = a;
    }

}
