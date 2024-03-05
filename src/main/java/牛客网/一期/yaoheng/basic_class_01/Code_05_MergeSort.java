package 牛客网.一期.yaoheng.basic_class_01;

/**
 * @author yaoheng5
 * @Classname Code_05_MergeSort
 * @Description 合并排序
 * @date 2022/7/18 21:41
 * @Created by yaoheng5
 */
public class Code_05_MergeSort extends AbstractSort {
    public static void main(String[] args) {
        new Code_05_MergeSort().start();
    }

    @Override
    protected void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        //易错：需要mid+1
        sort(arr, mid + 1, right);
        //易错：最后才可以执行排序操作
        value(arr, left, mid, right);
    }

    private void value(int[] arr, int left, int mid, int right) {
        int[] value = new int[right - left + 1];

        int leftIndex = left;
        int rightIndex = mid + 1;

        //移动小值到value中
        int i = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            value[i++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        //拷贝剩余的值到value
        while (leftIndex <= mid && rightIndex > right) {
            value[i++] = arr[leftIndex++];
        }
        while (leftIndex > mid && rightIndex <= right) {
            value[i++] = arr[rightIndex++];
        }

        //排序后数据放到原有队列
        for (int j = 0; j < value.length; j++) {
            arr[left + j] = value[j];//易错：需要从left开始加
        }
    }
}
/**
 * 总结：需要注意右边的值是mid+1开始，赋值给原数组的时候需要注意索引位置
 */
