package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 桶排序
 * 讲数据放到n个桶中，往每个桶里面存放数据
 */
public class a06BucketSort extends AbstractSort2 {
    public static void main(String[] args) {
        new a06BucketSort().start();
    }

    @Override
    void mySort(int[] as) {
        if (as == null || as.length < 2) {
            return;
        }
        //获取最大值
        int max = as[0];
        for (int i = 0; i < as.length; i++) {
            if (as[i] > max) {
                max = as[i];
            }
        }
        //新增数组
        int[] values = new int[max + 1];
        for (int i = 0; i < as.length; i++) {
            values[as[i]]++;
        }
        //存放数据
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != 0) {
                as[index++] = i;
                values[i]--;
            }
        }
    }
}
