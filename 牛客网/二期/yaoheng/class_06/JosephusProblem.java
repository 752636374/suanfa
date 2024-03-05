package 牛客网.二期.yaoheng.class_06;

import java.util.ArrayList;
import java.util.List;

/**
 * 复杂度： 该算法的时间复杂度为O(nk)，其中n是总人数，k是报数的间隔。每次删除一个人需要O(k)的时间，总共需要删除n-1个人，因此总时间复杂度为O(nk)。
 * <p>
 * 应用场景： 约瑟夫问题是一个经典的数学问题，可以用于解决环形链表、循环队列等相关的问题。它还可以用于模拟游戏、密码学以及其他需要按照一定规则进行排列的场景。
 * <p>
 * 实现逻辑： 首先创建一个列表people，其中包含从1到n的所有人。然后，使用循环从列表中移除人，直到只剩下最后一个人为止。在每一轮中，根据报数的间隔k计算出下一个要移除的人的索引，并将该人从列表中移除。最后，返回剩下的最后一个人。
 * <p>
 * 在main函数中，我们使用总人数n和报数的间隔k调用JosephusProblem函数，并打印最后剩下的幸存者。
 */
public class JosephusProblem {

    /**
     * @param n 人数
     * @param k 间隔
     * @return
     */
    public static int JosephusProblem(int n, int k) {
        // 创建一个整数列表来表示人员
        List<Integer> people = new ArrayList<>();

        // 将1到n的人员编号添加到列表中
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        // 初始化索引为0
        int index = 0;

        // 当列表中的人员数量大于1时，进行循环
        while (people.size() > 1) {
            // 根据规则计算下一个被移除的人员的索引
            index = (index + k - 1) % people.size();

            // 移除指定索引的人员
            people.remove(index);
        }

        // 返回最后剩下的人员编号
        return people.get(0);
    }


    public static void main(String[] args) {
        int n = 7; // 总人数
        int k = 3; // 报数的间隔
        int survivor = JosephusProblem(n, k);
        System.out.println("Survivor: " + survivor);
    }
}
