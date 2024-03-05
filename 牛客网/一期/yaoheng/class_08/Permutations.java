package 牛客网.一期.yaoheng.class_08;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现逻辑： printAllPermutations算法使用递归的方式生成给定字符串的所有排列。递归函数从字符串的第一个字符开始，通过不断交换字符的位置来生成不同的排列。
 * <p>
 * 实现步骤：
 * <p>
 * 创建一个递归函数printAllPermutations，用于生成所有排列。将给定的字符串转换为字符数组，然后调用辅助函数helper，初始时传入字符数组和索引0。
 * 在辅助函数helper中，首先判断当前处理的索引是否等于字符数组的长度减1，如果是，则打印当前的排列并返回。
 * 如果不是终止条件，使用循环遍历从当前索引到字符数组的末尾。在每次循环中，将当前索引的字符与循环变量所指向的字符交换位置，然后递归调用helper，将索引加1。
 * 在递归调用返回后，恢复字符数组的原始顺序，以便进行下一次排列。
 * 在主函数中，调用printAllPermutations函数并传入给定的字符串。
 * 这个算法通过不断交换字符的位置来生成不同的排列，通过递归的方式遍历所有可能的交换情况，最终生成了给定字符串的所有排列。
 * <p>
 * 注意：这个算法的时间复杂度是O(n!)，其中n是给定字符串的长度。因为排列的数量随着字符串长度的增加呈指数级增长。
 */
public class Permutations {
    /**
     * 打印给定字符串的所有排列
     *
     * @param str 给定的字符串
     */
    public static void printAllPermutations(String str) {
        char[] array = str.toCharArray();
        helper(array, 0);
    }

    /**
     * 打印给定字符串的所有排列
     *
     * @param str 给定的字符串
     */
    public static void printAllPermutations2(String str) {
        // 创建一个空的字符串列表，用于存储排列结果
        List<String> permutations = new ArrayList<>();
        // 将输入的字符串添加到列表中
        permutations.add(str);

        // 将字符串转换为字符数组
        char[] chars = str.toCharArray();
        // 获取字符数组的长度
        int n = chars.length;
        // 创建一个整数数组，用于记录每个字符在排列中的索引
        int[] indices = new int[n];

        // 初始化循环变量 i
        int i = 1;
        // 循环，生成所有可能的排列
        while (i < n) {
            // 如果当前字符的索引小于 i
            if (indices[i] < i) {
                // 根据 i 的奇偶性交换字符位置
                swap(chars, i % 2 == 0 ? 0 : indices[i], i);
                // 将交换后的字符数组转换为字符串，并添加到排列结果列表中
                permutations.add(new String(chars));
                // 增加当前字符的索引
                indices[i]++;
                // 重置 i 为 1，重新开始生成排列
                i = 1;
            } else {
                // 当前字符的索引已达到最大值，重置为 0，并递增 i
                indices[i] = 0;
                i++;
            }
        }

        // 遍历排列结果列表，打印每个排列
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }


    /**
     * 递归辅助函数，用于生成所有排列
     *
     * @param array 给定的字符数组
     * @param index 当前处理的索引
     */
    private static void helper(char[] array, int index) {

        if (index == array.length - 1) {
            System.out.println(new String(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            if (i != index) {
                swap(array, index, i);
            }

            helper(array, index + 1);
            if (i != index) {
                swap(array, index, i); // 恢复数组的原始顺序，以便进行下一次排列
            }

        }
    }

    static int num = 0;

    /**
     * 交换数组中两个元素的位置
     *
     * @param array 给定的字符数组
     * @param i     第一个元素的索引
     * @param j     第二个元素的索引
     */
    private static void swap(char[] array, int i, int j) {
        num++;
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllPermutations(str);
        System.out.println(num);
        num = 0;
        printAllPermutations2(str);
        System.out.println(num);
    }
}
