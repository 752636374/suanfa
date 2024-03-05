package 牛客网.一期.yaoheng.basic_class_01;

/**
 * @author yaoheng5
 * @Classname Code_06_BucketSort
 * @Description TODO
 * @date 2022/7/20 13:27
 * @Created by yaoheng5
 */
public class Code_06_BucketSort extends AbstractSort {
    public static void main(String[] args) {
        new Code_06_BucketSort().start();
    }

    /**
     * 桶排序：
     * 思路：1、将某大小的数据放到某个桶里，2、适用快排序对每个桶排序，3、将所有数据写入桶内
     * 时间复杂度：nlogn
     * 空间复杂度：nLogn
     * 适用场景：外排序，数据量大
     * 稳定性：
     *
     * @param arr
     */
    //only for 0-200 value
    @Override
    protected void sort(int[] arr) {
        //1、创造一个N+1大小的桶
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maxValue = arr[i] > maxValue ? arr[i] : maxValue;
        }
        //2、对每个桶进行快速
        int[] value = new int[maxValue + 1];
        for (int i = 0; i < arr.length; i++) {
            value[arr[i]]++;
        }

        //3、将数据写入
        int j = 0;
        for (int i = 0; i < value.length; i++) {
            while (value[i] > 0) {
                arr[j++] = i;
                value[i]--;
            }
        }

    }
}
