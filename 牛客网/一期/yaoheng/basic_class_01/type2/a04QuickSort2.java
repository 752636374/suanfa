package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 快速排序
 * 把小值放左边，大值放右边
 */
public class a04QuickSort2 extends AbstractSort2 {
    public static void main(String[] args) {
        new a04QuickSort2().start();
    }
    @Override
    void mySort(int[] as) {
        if (as == null || as.length < 2) {
            return;
        }
        index(as, 0, as.length - 1);
    }

    private void index(int[] as, int start, int end) {
        if (start < end) {
            //打乱顺序
            swap(as,(int)(start+Math.random()*(end-start)),end);
            int[] indexS = sort(as, start, end);
            index(as, start, indexS[0] - 1);
            index(as, indexS[1] + 1, end);
        }
    }

    private int[] sort(int[] as, int start, int end) {
        int less = start - 1;//小于值
        int more = end;//大于等于值
        int index = end;//待对比值
        while (start < more) {
            if (as[start] < as[index]) {
                swap(as, ++less, start++);
            } else if (as[start] > as[index]) {
                swap(as, start, --more);
            } else {
                start++;
            }
        }
        swap(as, more, index);
        return new int[]{less + 1, more};
    }
}
