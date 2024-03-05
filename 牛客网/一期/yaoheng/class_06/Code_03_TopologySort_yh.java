package 牛客网.一期.yaoheng.class_06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 该示例代码使用BFS（广度优先搜索）算法实现了拓扑排序。拓扑排序用于解决有向图中的依赖关系问题，例如课程的先修关系。在示例中，我们通过传入课程数量和先修关系数组来执行拓扑排序，并返回排序后的课程顺序。如果无法完成拓扑排序（即存在环），则返回一个空列表。
 *
 * 在示例中，我们使用入度数组和邻接表来表示有向图的结构。然后，我们使用BFS算法遍历图，将入度为0的节点加入队列，并依次处理其邻居节点。最后，我们检查排序后的课程数量是否与总课程数量相匹配，以确定是否存在环。
 *
 * 你可以根据自己的需求修改代码，例如修改输入数据、添加错误处理等。请注意，拓扑排序只适用于有向无环图（DAG），如果图中存在环，则无法进行拓扑排序。
 */
public class Code_03_TopologySort_yh {


    public static List<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
        // 构建入度数组和邻接表
        int[] inDegree = new int[numCourses]; // 每个节点的入度
        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses); // 邻接表，存储每个节点的邻居节点
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            inDegree[course]++; // 更新课程的入度
            adjacencyList.get(prerequisiteCourse).add(course); // 将课程添加到先修课程的邻接表中
        }

        // 使用BFS进行拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); // 将入度为0的节点加入队列
            }
        }

        List<Integer> sortedOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            sortedOrder.add(course); // 将节点加入排序结果中
            for (int neighbor : adjacencyList.get(course)) {
                inDegree[neighbor]--; // 将邻居节点的入度减1
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor); // 如果邻居节点的入度为0，则将其加入队列
                }
            }
        }

        // 判断是否存在环
        if (sortedOrder.size() != numCourses) {
            return new ArrayList<>(); // 如果排序结果的节点数量不等于总课程数量，说明存在环，返回空列表
        }

        return sortedOrder; // 返回拓扑排序结果
    }

    public static void main(String[] args) {
        int numCourses = 4;
        //入度表
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        List<Integer> sortedOrder = topologicalSort(numCourses, prerequisites);
        System.out.println(sortedOrder);
    }
}