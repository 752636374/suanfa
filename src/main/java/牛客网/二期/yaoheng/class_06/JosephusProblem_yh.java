package 牛客网.二期.yaoheng.class_06;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem_yh {
    public static void main(String[] args) {
        int people = 7;
        int sk = 3;
        int n = jose(people, sk);
        System.out.println(n);
    }

    private static int jose(int people, int sk) {
        //初始化人员
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= people; i++) {
            list.add(i);
        }
        //初始化索引
        int index = 0;
        //开始移除
        while (list.size() > 1) {
            index = (index+sk-1)% list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
