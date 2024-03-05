package 牛客网.一期.yaoheng.basic_class_01;

/**
 * 最好：
 * 最坏：
 * 平均：nlogn+N/2
 * 空间：
 * 稳定：不稳定
 * <p>
 * 注意：
 * 好处：
 * 坏处：
 * 适用场景：
 * 定义：给定一组数与一个值，比这个值小的在左边，大的在右边
 * <p>
 * 数据示例：
 *
 * @author yaoheng5
 * @Classname Code_08_NetherlandsFlag
 * @Description 荷兰国旗
 * @date 2022/7/24 16:18
 * @Created by yaoheng5
 */
public class Code_08_NetherlandsFlag extends AbstractSort {
    public static void main(String[] args) {
        new Code_08_NetherlandsFlag().sort(new int[]{1,2,3,4,5,6,7,8});
    }

    private int time = 0;
    private int size = 0;

    @Override
    protected void sort(int[] arr) {
        time = 0;
        size = 0;
        sort(arr, 0, arr.length - 1);
        System.out.println("time:" + time);
        System.out.println("size:" + size);
    }

    /**
     * @param arr   原数组
     * @param start 开始
     * @param end   结束
     */
    private void sort(int[] arr, int start, int end) {
        if (start >= end || end <= 0) {
            return;
        }
        int[] ints = getInts(arr, start, end);
        sort(arr, start, ints[0] - 1);
        sort(arr, ints[1] + 1, end);
    }

    private int[] getInts(int[] arr, int start, int end) {
        size++;
        if (start >= end) {
            return new int[]{-1, -1};
        }
        //小于mid的左边界
        int left = start;
        //大于mid的左边界
        int right = end - 1;
        //当前正在比较的下标
        int index = start;

        while (index <= right) {
            time++;
            if (arr[index] < arr[end]) {
                swap(arr, index++, left++);
            } else if (arr[index] > arr[end]) {
                swap(arr, index, right--);
            } else {
                index++;
            }
        }

        swap(arr, right + 1, end);

        return new int[]{left, right + 1};
    }

}
