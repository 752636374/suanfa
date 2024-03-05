package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 插入排序
 * 逻辑：用后面的数据对比前面的有序数据
 * 时间复杂度：n2
 * 空间复杂度：o1
 */
public class a01InsertionSort2 extends AbstractSort2 {
    public static void main(String[] args) {
        new a01InsertionSort2().start();
    }

    @Override
    void mySort(int[] as) {
        for (int i = 1; i < as.length; i++) {
            for (int j = 0; j < i; j++) {
                if (as[j] > as[i]) {
                    swap(as, i, j);
                }
            }
        }
    }
}
