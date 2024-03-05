package 牛客网.一期.yaoheng.basic_class_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A，有序
 * b，无序
 * 找寻b中无A的元素
 * 方案：采用2分对有序A查找，最多找寻logn次
 *
 * @author yaoheng5
 * @Classname Code_10_GetAllNotIncluded
 * @Description 获取所有不包括在内的
 * @date 2022/7/26 7:59
 * @Created by yaoheng5
 */
public class Code_10_GetAllNotIncluded extends AbstractSort {
    public static void main(String[] args) {
        Code_10_GetAllNotIncluded c = new Code_10_GetAllNotIncluded();
        int[] a = c.random(10, 10);
        int[] b = c.random(10, 10);
        Arrays.sort(a);
        c.print("a:", a);
        c.print("b:", b);

        List<Integer> value = c.get(a, b);
        int[] v = new int[value.size()];
        for (int i = 0; i < value.size(); i++) {
            v[i] = value.get(i);
        }
        c.print("v:", v);

    }

    @Override
    protected void sort(int[] arr) {

    }

    /**
     * 获取 B 中 A 不包含的元素
     *
     * @param A
     * @param B
     * @return
     */
    public List<Integer> get(int[] A, int[] B) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            boolean flag = true;
            int left = 0;
            int right = A.length - 1;
            int mid;
            while (left <= right) {
                mid = (left + ((right - left) >> 1));
                if (A[mid] == B[i]) {
                    flag = false;
                    break;
                }
                if (A[mid] < B[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (flag) {
                l.add(B[i]);
            }
        }
        return l;
    }

}
