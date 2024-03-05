package 牛客网.一期.teacher.basic_class_01;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Code_05_MergeSort {

    public static void mergeSort(int[] arr) {
        //小于等于1个值，不排序
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        //左右相等，到达终点
        if (l == r) {
            return;
        }
        //设置中值（>> ：开方）
        int mid = l + ((r - l) >> 1);
        //左边
        mergeSort(arr, l, mid);
        //右边
        mergeSort(arr, mid + 1, r);
        //排序
        merge(arr, l, mid, r);
    }

    /**
     * 排序
     * 较小值放左边，大值拷贝回去
     *
     * @param arr 数组
     * @param l   左值
     * @param m   中值
     * @param r   右值
     */
    public static void merge(int[] arr, int l, int m, int r) {
        //副本数组
        int[] help = new int[r - l + 1];
        //计数
        int i = 0;

        //左值索引
        int p1 = l;
        //右值索引
        int p2 = m + 1;
        //左值索引 <= 中值  &&  右值索引 <= 右边
        while (p1 <= m && p2 <= r) {
            //设置较小值
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //左索引值 <= 中值 && 右索引值 > 右值
        while (p1 <= m && p2 > r) {
            //赋值左边剩余的值
            help[i++] = arr[p1++];
        }
        while (p2 <= r && p1 > m) {
            //赋值右边剩余的值
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            //排序后值拷贝
            arr[l + i] = help[i];
        }
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
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
        mergeSort(arr);
        printArray(arr);

    }

}
