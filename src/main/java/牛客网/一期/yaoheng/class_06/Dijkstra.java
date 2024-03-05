package 牛客网.一期.yaoheng.class_06;

import java.util.Arrays;

/**
 * 注释：
 * <p>
 * dijkstra()函数使用Dijkstra算法计算给定图中从源节点到其他节点的最短路径。
 * main()函数是程序的入口点，用于创建图并调用dijkstra()函数。
 * 时间复杂度： Dijkstra算法的时间复杂度取决于使用的数据结构。使用优先队列实现的Dijkstra算法的时间复杂度为O((V + E) log V)，其中V是节点数，E是边数。
 * <p>
 * 空间复杂度： 空间复杂度取决于存储图和最短路径的数据结构。在这个实现中，使用了一个优先队列和一个数组来存储节点和最短距离，因此空间复杂度为O(V)。
 * <p>
 * 为什么这么写：
 * 优先队列用于按照节点的最短距离进行排序，以便在每次迭代中选择最短距离的节点。
 * 数组用于存储最短距离，以便在更新距离时进行查找和比较。
 * <p>
 * 优势：
 * Dijkstra算法能够找到单源最短路径，适用于没有负权边的图。
 * 使用优先队列可以在每次迭代中快速选择最短距离的节点，提高算法的效率。
 * <p>
 * 劣势：
 * Dijkstra算法在处理大规模图时的时间和空间复杂度较高。
 * 无法处理负权边，因为负权边可能导致算法陷入无限循环。
 */
public class Dijkstra {

    /**
     * 使用Dijkstra算法计算从起始节点到其他所有节点的最短路径
     *
     * @param graph     图的邻接矩阵表示
     * @param startNode 起始节点的索引
     * @return 包含最短路径的数组
     */
    public static int[] dijkstra(int[][] graph, int startNode) {
        int numNodes = graph.length;
        int[] dist = new int[numNodes];  // 存储起始节点到其他节点的最短距离
        boolean[] visited = new boolean[numNodes];  // 记录节点是否已被访问

        // 初始化距离数组和访问数组
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        for (int i = 0; i < numNodes - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int minIndex = -1;

            // 选择距离最小的节点作为当前节点
            for (int v = 0; v < numNodes; v++) {
                if (!visited[v] && dist[v] <= minDist) {
                    minDist = dist[v];
                    minIndex = v;
                }
            }

            // 标记当前节点为已访问
            visited[minIndex] = true;

            // 更新与当前节点相邻节点的最短距离
            for (int v = 0; v < numNodes; v++) {
                if (!visited[v] &&
                        graph[minIndex][v] != 0
                        && dist[minIndex] != Integer.MAX_VALUE
                        && dist[minIndex] + graph[minIndex][v] < dist[v]) {
                    dist[v] = dist[minIndex] + graph[minIndex][v];
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int startNode = 0;
        int[] shortestDistances = dijkstra(graph, startNode);

        System.out.println("从节点 " + startNode + " 出发的最短路径：");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("到达节点 " + i + " 的最短距离为：" + shortestDistances[i]);
        }
    }
}



