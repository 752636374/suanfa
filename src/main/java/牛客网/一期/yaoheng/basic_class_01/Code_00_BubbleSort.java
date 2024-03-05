package 牛客网.一期.yaoheng.basic_class_01;

/**
 * @author yaoheng5
 * @Classname Code_01_InsertionSort
 * @Description 冒牌排序
 * ****
 * ***
 * **
 * *
 * 双重循环，每次排序
 * @date 2022/7/4 22:43
 * @Created by yaoheng5
 */
public class Code_00_BubbleSort extends AbstractSort {

    public static void main(String[] args) {
        new Code_00_BubbleSort().start();
    }

    @Override
    public void sort(int[] types) {
        for (int i = types.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (types[j] > types[i]) {
                    swap(types, i, j);
                }
            }
        }
    }
}
