package 牛客网.一期.yaoheng.class_08;

import java.util.ArrayList;
import java.util.List;

/**
 * 采用递归实现，
 * 时间复杂度n的阶乘
 */
public class Permutations_yh {

    public static void main(String[] args) {
        printAllPermutations("abc");
        printAllPermutations2("abc");
    }

    private static void printAllPermutations2(String word) {
        char[] chars = word.toCharArray();
        List<Integer> list = new ArrayList<>();

        for (char c : chars) {

        }
    }

    private static void printAllPermutations(String word) {
        char[] chars = word.toCharArray();
        help(chars, 0);
    }

    private static void help(char[] chars, int index) {
        //基本情况
        if (index == chars.length) {
            System.out.println(chars);
            return;
        }

        //递归调用
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            help(chars, index + 1);
            swap(chars, index, i);
        }
    }

    private static void swap(char[] chars, int index, int i) {
        char tmp = chars[i];
        chars[i] = chars[index];
        chars[index] = tmp;
    }
}
