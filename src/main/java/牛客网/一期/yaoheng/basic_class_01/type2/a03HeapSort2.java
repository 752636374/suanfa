package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 逻辑：利用堆的数据结构，先保证父节点最大，然后移动父节点数据到最后一位，不断保证数据结构为大顶堆。
 * 时间复杂度：nlogn
 * 空间复杂度：
 *
 *
 */
public class a03HeapSort2 extends AbstractSort2 {
    public static void main(String[] args) {
        new a03HeapSort2().start();
    }

    @Override
    void mySort(int[] as) {
        if (as == null || as.length < 2) {
            return;
        }
        //设置大顶堆
        for (int i = 0; i < as.length; i++) {
            heapInsert(as, 0, i);
        }
        //移动最大的值到最后
        swap(as, 0, as.length - 1);
        for (int i = as.length; i > 0; i--) {
            //移动最大的值到首位
            heapMax(as, 0, i);
            //移动最大的值到最后
            swap(as, 0, i - 1);
        }
    }

    /**
     * 设置大顶堆
     * 每次比较父节点与子节点，保持父节点最大
     * 从后到前，加入新数
     * @param as
     * @param m
     * @param length
     */
    public void heapInsert(int[] as, int m, int length) {
        int index = length;
        while (m < index) {
            if (as[index] > as[(index - 1) / 2]) {
                swap(as, index, (index - 1) / 2);
            }
            index = (index - 1) / 2;
        }
    }

    /**
     * 保持最大值在第一位
     * 从前到后，排序数据
     *
     * @param as
     * @param m
     * @param index
     */
    public void heapMax(int[] as, int m, int index) {
        int largest;
        while (2 * m + 1 < index) {
            //获取子节点中大的值
            largest = (2 * m + 2) < index && as[2 * m + 1] < as[2 * m + 2] ? (2 * m + 2) : (2 * m + 1);
            //获取子与父节点中大值
            largest = as[m] > as[largest] ? m : largest;
            if (m == largest) {
                break;
            }
            swap(as, largest, m);
            m = largest;
        }
    }
}
