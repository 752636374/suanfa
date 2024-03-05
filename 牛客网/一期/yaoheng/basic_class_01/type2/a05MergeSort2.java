package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 归并排序
 * 方法：分为左右分别排序，然后左右两个数组再一起排序
 * 平均时间：nLogn
 * 最好时间：
 * 最差时间：
 * 稳定性：
 * 排序方式：
 * 空间复杂度：logn
 */
public class a05MergeSort2 extends AbstractSort2 {
    public static void main(String[] args) {
        new a05MergeSort2().start();
    }

    @Override
    void mySort(int[] as) {
        if (as == null || as.length < 2) {
            return;
        }
        merge(as, 0, as.length - 1);
    }

    /**
     * 左右两边分别计算
     *
     * @param as
     * @param l
     * @param r
     */
    public void merge(int[] as, int l, int r) {
        //终止条件
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        merge(as, l, mid);
        merge(as, mid + 1, r);
        sort(as, l, mid, r);
    }

    /**
     * 对指定的区间排序
     *
     * @param as
     * @param l
     * @param m
     * @param r
     */
    public void sort(int[] as, int l, int m, int r) {
        int[] asb = new int[r - l + 1];
        int left = l;
        int right = m + 1;
        int index = 0;

        while (left <= m && right <= r) {
            if (as[left] < as[right]) {
                asb[index] = as[left++];
            } else {
                asb[index] = as[right++];
            }
            index++;
        }

        while (left <= m) {
            asb[index++] = as[left++];
        }

        while (right <= r) {
            asb[index++] = as[right++];
        }

        for (int i = 0; i < asb.length; i++) {
            as[l + i] = asb[i];
        }
    }

}
