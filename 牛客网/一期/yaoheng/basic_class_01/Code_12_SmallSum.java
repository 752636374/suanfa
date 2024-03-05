package 牛客网.一期.yaoheng.basic_class_01;

/**
 * 定义：求小和：求一个数据左边比小的数据之和
 * 举例：[4,2,1,4]  0+0+0+(2+1)=3
 * 空间：logn
 * 平均时间：nlog2n
 * 最好时间：
 * 最差时间：
 * 实现步骤：
 * 1、添加左边小的数据
 * 2、数据排序
 *
 * @author yaoheng5
 * @Classname Code_12_SmallSum
 * @Description
 * @date 2022/7/27 22:06
 * @Created by yaoheng5
 */
public class Code_12_SmallSum extends AbstractSort {
    public static void main(String[] args) {
        Code_12_SmallSum c = new Code_12_SmallSum();
        int i = 0;
        boolean flag = true;
        while (i++ < 100) {
            int[] arr1 = c.random(10, 100);
            int[] arr2 = c.copy(arr1);
            int result1 = myGetMin(arr1, 0, arr1.length - 1);
            int result2 = getMin(arr2);
            if (result1 != result2) {
                flag = false;
                System.out.println("result1:" + result1);
                System.out.println("result2:" + result2);
                break;
            }
        }
        System.out.println(flag ? "nice" : "fuck");
    }

    private static int getMin(int[] arr2) {
        int result = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr2[j] < arr2[i]) {
                    result += arr2[j];
                }
            }
        }
        return result;
    }

    private static int myGetMin(int[] arr1, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);

        return myGetMin(arr1, left, mid) + myGetMin(arr1, mid + 1, right) + myGetMinValue(arr1, left, mid, right);
    }

    /**
     * 步骤：
     * 1、计算右边比左边大的数据
     * 2、对数据排序
     *
     * @param arr1
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private static int myGetMinValue(int[] arr1, int left, int mid, int right) {
        if (left == right) {
            return 0;
        }
        int result = 0;
        int[] help = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        //左右同时有数据时
        int h = 0;
        while (l <= mid && r <= right) {
            result += arr1[l] < arr1[r] ? arr1[l] * (right - r + 1) : 0;
            help[h++] = arr1[l] < arr1[r] ? arr1[l++] : arr1[r++];
        }
        //左边数据加入
        while (l <= mid) {
            help[h++] = arr1[l++];
        }
        //右边数据加入
        while (r <= right) {
            help[h++] = arr1[r++];
        }
        //归还到原数组
        for (int i = 0; i < help.length; i++) {
            arr1[left + i] = help[i];
        }

        return result;
    }

    @Override
    protected void sort(int[] arr) {

    }
}
