package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 选择排序
 * 逻辑：选择最小或者最大的值放在开始位置
 * 时间复杂度：n2
 * 空间复杂度：01
 */
public class a02SelectionSort2 extends AbstractSort2 {
    public static void main(String[] args) {
        new a02SelectionSort2().start();
    }

    @Override
    void mySort(int[] as) {
        for (int i = 0; i < as.length; i++) {
            int min = i;
            for (int j = i; j < as.length; j++) {
                if (as[min] > as[j]) {
                    min = j;
                }
            }
            swap(as, min, i);
        }
    }
}
