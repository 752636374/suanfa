package 牛客网.一期.yaoheng.basic_class_01;

/**
 *
 * 1/将大值移动到右边，小值不动。
 * 2/交换索引数据与在最左位置的 大值
 * 3/循环
 * @author yaoheng5
 * @Classname Code_04_QuickSort
 * @Description TODO
 * @date 2022/7/16 15:47
 * @Created by yaoheng5
 */
public class Code_04_QuickSort extends AbstractSort {
    public static void main(String[] args) {
        new Code_04_QuickSort().start();
    }

    @Override
    protected void sort(int[] arr) {
        //排序数据
        splitData(arr, 0, arr.length - 1);
    }

    private void splitData(int[] arr, int left, int right) {
        if (left < right) {
            // 1、 划分数据大小区域
            int[] data = point(arr, left, right);

            // 2、划分左边
            splitData(arr, left, data[0] - 1);

            //3、划分右边
            splitData(arr, data[1] + 1, right);
        }
    }

    /**
     * @param arr
     * @param min
     * @param max
     * @return
     */
    private int[] point(int[] arr, int min, int max) {
        //索引值
        int indexValue = max;
        //换位值
        int wap = max;

        //左边索引
        int left = min;
        //右边索引
        int right = max - 1;


        while (left <= right) {
            if (arr[left] > arr[indexValue]) {
                //设置大值到右边
                swap(arr, left, right);
                //右边索引左移
                right--;
                wap--;
            } else if (arr[left] < arr[indexValue]) {
                left++;
            } else {
                left++;
            }
        }

        //交换 大值与索引值
        swap(arr, indexValue, wap);

        //返回 索引值，大值 位置
        return new int[]{left, wap};
    }
}
