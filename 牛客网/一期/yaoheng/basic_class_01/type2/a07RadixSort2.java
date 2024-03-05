package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 基数排序
 */
public class a07RadixSort2 extends AbstractSort2 {
    public static void main(String[] args) {
        new a07RadixSort2().start();
    }

    @Override
    void mySort(int[] as) {
        if (as == null || as.length < 2) {
            return;
        }
        sort(as, 0, as.length - 1, getMaxLength(as));
    }

    /**
     * 计算每一位有多少个
     * 累计计算数据
     * 排序赋值
     *
     * @param maxLength
     */
    private void sort(int[] as, int start, int end, int maxLength) {
        int len = 10;
        int length = end - start + 1;
        int[] counts = new int[len];
        int[] buckets = new int[length];

        for (int i = 1; i <= maxLength; i++) {
            //数据复位
            for (int j = 0; j < counts.length; j++) {
                counts[j] = 0;
            }

            //计算数据的数据量
            for (int j = 0; j < as.length; j++) {
                counts[getNum(as[j], i)]++;
            }
            for (int j = 1; j < counts.length; j++) {
                counts[j] = counts[j] + counts[j - 1];
            }

            //在桶中存放数数据，从高位开始放
            for (int j = as.length - 1; j >= 0; j--) {
                int index = counts[getNum(as[j], i)];
                buckets[index - 1] = as[j];
                counts[getNum(as[j], i)]--;
            }

            //赋值到原数组
            for (int j = 0; j < as.length; j++) {
                as[j] = buckets[j];
            }
        }
    }

    private int getNum(int num, int index) {
//        String res = String.valueOf(num);
//        if (res.length() < index) {
//            return 0;
//        }
//        String result = res.substring(res.length() - index, res.length() - index + 1);
//        return Integer.valueOf(result);

        return ((num / ((int) Math.pow(10, index - 1))) % 10);

    }

    private int getMaxLength(int[] as) {
        int max = 0;
        int maxIn;
        int cu;
        for (int i = 0; i < as.length; i++) {
            maxIn = 1;
            cu = as[i];
            while (cu / 10 > 0) {
                maxIn++;
                cu = cu / 10;
            }
            if (maxIn > max) {
                max = maxIn;
            }
        }
        return max;
    }
}
