package 牛客网.一期.yaoheng.basic_class_01.type2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a10GetAllNotInclued extends AbstractSort2 {
    public static void main(String[] args) {
        a10GetAllNotInclued a = new a10GetAllNotInclued();
        int[] a1 = a.random(10, 10);
        int[] a2 = a.random(10, 10);
        Arrays.sort(a1);
        a.print("a1:",a1);
        a.print("a2:",a2);
        List<Integer> a3 = a.include(a1, a2);
        System.out.println(a3);

    }

    /**
     * a1有序
     * 采用二分查找，快速找到不包含的数据
     *
     * @param a1
     * @param a2
     * @return
     */
    private List<Integer> include(int[] a1, int[] a2) {
        int begin;
        int end;
        int mid;
        boolean isContain;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a2.length; i++) {
            begin = 0;
            end = a1.length - 1;
            mid = begin + (end - begin) >> 2;
            isContain = true;
            while (begin < end) {
                if (a1[mid] == a2[i]) {
                    list.add(a2[i]);
                    isContain = false;
                }
                if (a1[i] < a1[mid]) {
                    end = mid;
                } else {
                    begin = mid;
                }
            }
            if (isContain) {
                list.add(a2[i]);
            }
        }
        return list;
    }

    @Override
    void mySort(int[] as) {

    }
}
