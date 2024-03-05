package 牛客网.一期.yaoheng.basic_class_01;

/**
 * @author yaoheng5
 * @Classname Code_03_HeapSort
 * @Description 堆排序
 * @date 2022/7/7 8:13
 * @Created by yaoheng5
 */
public class Code_03_HeapSort extends AbstractSort {
    public static void main(String[] args) {
        new Code_03_HeapSort().start();
    }

    @Override
    protected void sort(int[] arr) {
        //排序：设置父节点为最大值
        setHeap(arr);
        int size = arr.length;

        //排序：每次将最大值放到最后
        while (size > 0) {
            //数组归位：保证父节点最大
            setMaxHeap(arr, 0, size);
            //移位数据：将最大值放到最后
            swap(arr, 0, --size);
        }
    }

    /**
     * 设置父节点最大
     * 1、获取三个中最大值，设置到父节点
     * 2、轮训下一个被交换位置的节点
     *
     * @param arr
     * @param i
     * @param size
     */
    private void setMaxHeap(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = left + 1;
        int index = i;
        int largest = i;
        while (left < size) {
            //找寻最大值索引
            largest = arr[index] > arr[left] ? index : left;
            if (right < size) {
                largest = arr[largest] > arr[right] ? largest : right;
            }

            if (largest == index) {
                break;
            }

            //交换位置
            swap(arr, largest, index);

            //设置新值，开始下一轮
            index = largest;
            left = 2 * index + 1;
            right = left + 1;
        }
    }

    /**
     * 轮训每一个节点，保证父节点比自己大
     *
     * @param arr
     */
    private void setHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            //设置变量
            int index = i;
            int parent = (index - 1) / 2;

            while (arr[index] > arr[parent]) {

                //交换当前与父亲
                swap(arr, index, parent);

                //下一轮初始值
                index = parent;
                parent = (index - 1) / 2;
            }
        }
    }
}
