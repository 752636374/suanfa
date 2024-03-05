package 牛客网.一期.yaoheng.basic_class_01;

/**
 * 总结：
 * 1、画图查看数据流向，清楚每个数据流向位置
 * 2、注意赋值时为了保持原有数据顺序，需要倒序赋值
 * 3、
 * <p>
 * 指标
 * 平均：d(r+n)
 * 最好：d(r+n)
 * 最坏：d(rd+n)
 * 空间：rd+n
 * 稳定：稳定
 *
 * @author yaoheng5
 * @Classname Code_07_RadixSort
 * @Description 基数排序
 * @date 2022/7/22 13:24
 * @Created by yaoheng5
 */
public class Code_07_RadixSort extends AbstractSort {
    public static void main(String[] args) {
        new Code_07_RadixSort().start();
    }

    /**
     * 推演示例：
     * 原始：[123,411,523]
     * 个位：[411,123,523]
     * 十位：[411,123,523]
     * 百位：[123,411,523]
     * 最终：[123,411,523]
     *
     * @param arr
     */
    @Override
    protected void sort(int[] arr) {
        sort(arr, 0, arr.length, getBit(arr));
    }

    /**
     * 步骤
     * 1、定义桶
     * 2、对数据排序
     * 3、赋值给原数组
     *
     * @param arr
     * @param start
     * @param end
     * @param bit
     */
    private void sort(int[] arr, int start, int end, int bit) {

        //定义桶
        int maxIndex = 10;
        int[] indexs = new int[maxIndex];
        int[] buckets = new int[end - start];

        //排序
        int now = 1;
        while (now <= bit) {

            //初始值都设置为0
            for (int i = 0; i < indexs.length; i++) {
                indexs[i] = 0;
            }

            //给索引赋值
            for (int i = start; i < end; i++) {
                int j = getValue(arr[i], now);
                indexs[j]++;
            }

            //准备给原始队列赋值
            for (int i = 1; i < indexs.length; i++) {
                indexs[i] = indexs[i - 1] + indexs[i];
            }

            //设置桶值
            for (int i = end - 1; i >= start; i--) {
                int j = getValue(arr[i], now);
                int valueIndex = indexs[j];
                indexs[j]--;
                buckets[valueIndex - 1] = arr[i];
            }

            //赋值给原有队列
            int j = 0;
            for (int i = start; i < end; i++) {
                arr[i] = buckets[j++];
            }

            now++;
        }


    }

    /**
     * 获取 value 值 第 index 位 的数据
     *
     * @param value 当前值
     * @param index 索引值
     * @return
     */
    private int getValue(int value, int index) {
        return ((value / ((int) Math.pow(10, index - 1))) % 10);
    }

    private int getBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        int length = 0;
        while (max != 0) {
            length++;
            max /= 10;
        }
        return length;
    }
}
