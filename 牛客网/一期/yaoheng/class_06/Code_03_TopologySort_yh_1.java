package 牛客网.一期.yaoheng.class_06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_03_TopologySort_yh_1 {


    public static void main(String[] args) {
        int num = 4;
        //定义有向图数组
        int[][] as = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        //调用排序数组
        List<Integer> list = topologcalSort(num, as);
        //输出数据
        System.out.println(list);

    }

    private static List<Integer> topologcalSort(int num, int[][] prerequisites) {
        //构建领接表
        int[] inDegree = new int[num];
        List<List<Integer>> adjacency = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            inDegree[course]++;
            adjacency.get(prerequisiteCourse).add(course);
        }

        //排序
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> sortedOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            sortedOrder.add(course);
            for (int neighbor : adjacency.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        //判断是否有环
        if (sortedOrder.size() != num) {
            return new ArrayList<>();
        }


        return sortedOrder;
    }
}
