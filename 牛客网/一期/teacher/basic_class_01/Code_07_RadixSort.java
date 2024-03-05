package 牛客网.一期.teacher.basic_class_01;

import java.util.Arrays;

/**
 * 将数据按 个 十 百 千 等每个位置比较
 * 先比较低位，然后高位
 *
 * 基数排序
 */
public class Code_07_RadixSort {

    // only for no-negative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 求出位数
     *
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr) {
        //找寻最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        //划分为 10
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     *
     * @param arr       数组
     * @param begin     开始
     * @param end       结束
     * @param digit     最大位数
     */
    public static void radixSort(int[] arr, int begin, int end, int digit) {
        //设置桶大小为10,用于存0-9数字
        final int radix = 10;
        int i = 0, j = 0;
        //计数：计算每一位的数量
        int[] count = new int[radix];
        //桶：存放临时数据
        int[] bucket = new int[end - begin + 1];
        //求每一位的排序
        for (int d = 1; d <= digit; d++) {

            //初始化每一个为0
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }

            //设置计数器值，每一位有一个则 +1
            //如：[0,0,2,4,5,0,0,0,0,0] 表示2（2个），3（4个），4（5个），其他（0个）
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], d);//获取数字的位数值
                count[j]++;
            }

            //计算小于等于当前值的总个数，累加数据量
            //如：111,123,390 )>
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            //设置桶值
            for (i = end; i >= begin; i--) {
                //获取arr[i] 第 d 的值
                j = getDigit(arr[i], d);
                //从大到小设置索引值
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            //将排序后的值赋值给原值
            for (i = begin, j = 0; i <= end; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    /**
     * 求 x 第 d 位 数据（从低到高）
     * 如：
     * x=98789,d= 1        <计算后>  9
     * x=98789,d= 2        <计算后>  8
     *
     * @param x 原数据
     * @param d 个十百千... 其中之一的位数
     * @return
     */
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500;
        int maxSize = 10;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        radixSort(arr);
        printArray(arr);

    }

}
