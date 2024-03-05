package 牛客网.一期.teacher.basic_class_01;

/**
 * 将每一个比当前数小的左边的数累加起来称作这个数组的小和，求该数组的小和。
 */
public class Code_12_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        System.out.println("start——————————————————————————————");
        int i = mergeSort(arr, 0, arr.length - 1);
        System.out.println("end——————————————————————————————");
        return i;
    }

    /**
     * 合并排序
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        //左边执行完+右边执行完
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    /**
     * @param arr 数组
     * @param l   左
     * @param m   中
     * @param r   右
     * @return
     */
    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        //左右都为走完
        while (p1 <= m && p2 <= r) {
            //左边小的时候，右边剩下的都更大
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            //排序，把小的数据存放到help中
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //左侧剩余的值
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        //右侧剩余的值
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //赋值回原数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        System.out.println(res);
        return res;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
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
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
