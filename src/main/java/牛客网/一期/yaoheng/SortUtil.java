package 牛客网.一期.yaoheng;

import java.util.Arrays;

/**
 * @author yaoheng5
 * @Classname SortUtil
 * @Description TODO
 * @date 2022/7/7 6:46
 * @Created by yaoheng5
 */
public class SortUtil {
    private static boolean isEquals(int[] array2, int[] arrays1) {
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

    private static void print(int[] arrays1) {
        for(int i=0;i<arrays1.length;i++){
            System.out.print(arrays1[i]+" ");
        }
        System.out.println();
    }

    private static void dofaultSort(int[] array2) {
        Arrays.sort(array2);
    }

    private static int[] copy(int[] arrays1) {
        int[] arr = new int[arrays1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrays1[i];
        }
        return arr;
    }

    private static int[] random(int maxLength, int maxValue) {
        int[] arr = new int[maxLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (Math.random());
        }
        return arr;
    }




    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
