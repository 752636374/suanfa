package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 冒牌排序
 * 时间复杂度：n2
 * 空间复杂度：o1
 */
public class a00BubbleSort2 extends AbstractSort2 {
    public static void main(String[] args) {
        new a00BubbleSort2().start();
    }

    @Override
    void mySort(int[] as) {
        for (int i = 0; i < as.length; i++) {
            for (int j = 0; j < as.length - i - 1; j++) {
                if (as[j] > as[j + 1]) {
                    swap(as, j, j + 1);
                }
            }
        }
    }
}
