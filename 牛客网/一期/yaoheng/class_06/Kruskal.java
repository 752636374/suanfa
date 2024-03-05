package 牛客网.一期.yaoheng.class_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kruskal算法是一种用于解决最小生成树问题的贪心算法。它通过选择权重最小的边来逐步构建最小生成树。以下是对代码中的关键部分进行注释解释：
 *
 * Edge类：表示图中的边，包括源节点、目标节点和权重，并实现了Comparable接口以便排序。
 * KruskalAlgorithm类：包含Kruskal算法的实现。
 * edges：存储图中的边。
 * parent：用于实现并查集的数组，用于判断两个节点是否属于同一个连通分量。
 * addEdge方法：用于向图中添加边。
 * kruskalMST方法：执行Kruskal算法，返回最小生成树的边集合。
 * find方法：查找节点的根节点，并进行路径压缩优化。
 * union方法：将两个节点所在的连通分量合并。
 * main方法：创建一个示例图并运行Kruskal算法，输出最小生成树的边。
 * 时间复杂度：Kruskal算法的时间复杂度主要取决于边的排序操作，为O(E log E)，其中E是边的数量。并查集操作的时间复杂度为O(log V)，其中V是节点的数量。
 *
 * 空间复杂度：Kruskal算法的空间复杂度为O(V)，其中V是节点的数量，用于存储并查集的父节点数组。
 *
 * 优势：Kruskal算法具有以下优势：
 *
 * 适用于稀疏图，即边的数量相对较少的情况。
 * 可以处理带有边权重的图，适用于实际应用中需要考虑边权重的场景。
 * 算法简单且易于理解，实现相对较为简单。
 * 适用场景：Kruskal算法适用于以下场景：
 *
 * 需要找到最小生成树的问题。
 * 图是稀疏图，即边的数量相对较少。
 * 图中的边具有权重，需要考虑边权重的情况。
 * 总结：Kruskal算法是一种简单且有效的贪心算法，用于解决最小生成树问题。它通过选择权重最小的边来构建最小生成树，并且适用于稀疏图和考虑边权重的场景。
 */
public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int source;  // 边的起始节点
        int destination;  // 边的目标节点
        int weight;  // 边的权重

        public Edge(int source, int destination, int weight) {
            this.source = source;  // 初始化边的起始节点
            this.destination = destination;  // 初始化边的目标节点
            this.weight = weight;  // 初始化边的权重
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;  // 比较边的权重
        }
    }


    static class KruskalAlgorithm {
        List<Edge> edges; // 存储边的列表
        int[] parent; // 存储节点的父节点索引

        // 构造函数，初始化边列表和父节点数组
        public KruskalAlgorithm(int vertices) {
            edges = new ArrayList<>();
            parent = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        // 添加一条边
        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            edges.add(edge);
        }

        // 执行Kruskal算法，返回最小生成树
        public List<Edge> kruskalMST() {
            List<Edge> minimumSpanningTree = new ArrayList<>();
            Collections.sort(edges); // 按权重对边进行排序

            // 遍历所有边
            for (Edge edge : edges) {
                int sourceParent = find(edge.source);
                int destinationParent = find(edge.destination);

                // 判断是否会形成环路
                if (sourceParent != destinationParent) {
                    minimumSpanningTree.add(edge);
                    union(sourceParent, destinationParent);
                }
            }

            return minimumSpanningTree;
        }

        // 查找节点所属的集合
        private int find(int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]);
            }
            return parent[vertex];
        }

        // 合并两个集合
        private void union(int source, int destination) {
            parent[source] = destination;
        }

        // 主函数，用于测试
        public static void main(String[] args) {
            int vertices = 6;
            KruskalAlgorithm kruskal = new KruskalAlgorithm(vertices);

            // 添加边
            kruskal.addEdge(0, 1, 4);
            kruskal.addEdge(0, 2, 3);
            kruskal.addEdge(1, 2, 1);
            kruskal.addEdge(1, 3, 2);
            kruskal.addEdge(2, 3, 4);
            kruskal.addEdge(3, 4, 2);
            kruskal.addEdge(4, 5, 6);

            // 执行Kruskal算法并打印结果
            List<Edge> minimumSpanningTree = kruskal.kruskalMST();
            System.out.println("Minimum Spanning Tree:");
            for (Edge edge : minimumSpanningTree) {
                System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
            }
        }
    }

}

