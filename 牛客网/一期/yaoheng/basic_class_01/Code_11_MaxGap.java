package 牛客网.一期.yaoheng.basic_class_01;

import java.util.Arrays;

/**
 * 空间：3N
 * 最佳时间：2n+s
 * 平局时间：2n+s
 * 最差时间：2n+s
 * 注意：
 * 1、桶的个数为N+1
 * 2、数据多次求余会造成数据丢失，要用一个算式
 * 步骤：
 * 1、初始化n+1个桶：用于存放n个桶的数据，其中一个桶必然为空
 * 2、下一个桶最小值 与 上一个桶最大值的差
 *
 *
 * @author yaoheng5
 * @Classname Code_11_MaxGap
 * @Description 最大间隙
 * @date 2022/7/26 21:56
 * @Created by yaoheng5
 */
public class Code_11_MaxGap extends AbstractSort {
    public static void main(String[] args) {
        Code_11_MaxGap c = new Code_11_MaxGap();
        boolean flag = false;
        for (int i = 0; i < 100; i++) {
            int[] value = c.random(10, 100);
            int result = getMaxGap(value);
            int result2 = getDefalut(value);
            if (result != result2) {
                c.print("value", value);
                System.out.println("result1:" + result);
                System.out.println("result2:" + result2);
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "fuck" : "nice");

    }

    private static int getDefalut(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);

        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            current = nums[i + 1] - nums[i];
            max = Math.max(current, max);

        }
        return max;
    }

    private static int getMaxGap(int[] value) {
        //获取最小值，最大值
        int min = value[0];
        int max = value[0];
        int length = value.length;
        for (int i = 0; i < value.length; i++) {
            min = min < value[i] ? min : value[i];
            max = max > value[i] ? max : value[i];
        }

        //设置三个 数组：最小值，最大值，是否有值
        int[] mins = new int[length + 1];
        int[] maxs = new int[length + 1];
        boolean[] hasV = new boolean[length + 1];
        int bucketIndex = 0;
        for (int i = 0; i < value.length; i++) {
            bucketIndex = getBucketIndex(value[i], min, max, length);
            mins[bucketIndex] = hasV[bucketIndex] ? Math.min(mins[bucketIndex], value[i]) : value[i];
            maxs[bucketIndex] = hasV[bucketIndex] ? Math.max(maxs[bucketIndex], value[i]) : value[i];
            hasV[bucketIndex] = true;
        }

        //获取最大值：上一个的最大值，当前的最小值
        int result = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= length; i++) {
            if (hasV[i]) {
                result = Math.max(result, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return result;
    }

    /**
     * 获取 i 在 min与max 之间 长度为length的桶的序号
     * 注意：多次取除数，会对精度造成丢失
     *
     * @param num    数值
     * @param min    最小值
     * @param max    最大值
     * @param length 桶个数
     * @return
     */
    private static int getBucketIndex(int num, int min, int max, int length) {
/*        //每个桶的取值范围
        int bucketLength = (max - min) / length;
        //当前所在范围
        int index = (num - min) / bucketLength;
        //返回桶号
        return index;*/

        return (num - min) * length / (max - min);
    }

    @Override
    protected void sort(int[] arr) {

    }
}
