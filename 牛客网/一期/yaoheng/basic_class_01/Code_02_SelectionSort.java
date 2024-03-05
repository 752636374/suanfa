package 牛客网.一期.yaoheng.basic_class_01;

/**
 * @author yaoheng5
 * @Classname Code_02_SelectionSort
 * @Description 选择排序
 * @date 2022/7/7 7:10
 * @Created by yaoheng5
 */
public class Code_02_SelectionSort extends AbstractSort {
    public static void main(String[] args) {
        new Code_02_SelectionSort().start();
    }

    /**
     * 定义最小的索引
     * 找出比最小值更小的值，交换数据
     *
     * @param arr
     */
    @Override
    protected void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }
}
