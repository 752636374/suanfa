package 牛客网.一期.yaoheng.basic_class_01;

/**
 * @author yaoheng5
 * @Classname Code_01_InsertionSort
 * @Description 插入排序
 * @date 2022/7/7 6:32
 * @Created by yaoheng5
 */
public class Code_01_InsertionSort extends AbstractSort {
    public static void main(String[] args) {
        new Code_01_InsertionSort().start();
    }

    /**
     * 比较前一个是否比后一个大，大则交换位置
     * @param array
     */
    @Override
    protected void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j+1, j);
            }
        }
    }
}
