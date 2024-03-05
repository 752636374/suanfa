package 牛客网.一期.yaoheng.class_06;

/**
 * 空间复杂度：Prim 算法的空间复杂度为 O(V + E)，其中 V 是顶点数，E 是边数。
 * <p>
 * 时间复杂度：Prim 算法的时间复杂度为 O((V + E) log V)，其中 V 是顶点数，E 是边数。这是因为算法使用了优先队列来选择最小权重的边。
 * <p>
 * 适用场景：Prim 算法适用于求解无向图的最小生成树问题，特别是当图是稠密图时（边数接近于顶点数的平方），Prim 算法的效率更高。
 * <p>
 * 优劣势：
 * <p>
 * 优势：Prim 算法具有以下优点：
 * 在稠密图中表现良好，效率高。
 * 可以处理带有负权边的图。
 * 生成的最小生成树是连通且具有最小权重的。
 * 劣势：Prim 算法的劣势在于：
 * 对于稀疏图（边数远小于顶点数的平方）效率较低，因为需要遍历所有顶点。
 * 不适用于有向图。
 * 对于边权重相同的情况，可能有多个最小生成树。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PrimAlgorithm {

    //边缘
    static class Edge {
        int source;  // 边的起点
        int destination;  // 边的终点
        int weight;  // 边的权重

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    //节点
    static class Node implements Comparable<Node> {
        int vertex;  // 节点的编号
        int weight;  // 节点的权重

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(weight, other.weight);
        }
    }

    private List<List<Edge>> graph;  // 图的邻接表表示
    private boolean[] visited;  // 记录节点是否被访问过
    private int[] parent;  // 记录节点的父节点
    private int[] key;  // 记录节点的权重

    public PrimAlgorithm(int vertices) {
        graph = new ArrayList<>(vertices);
        visited = new boolean[vertices];
        parent = new int[vertices];
        key = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
            key[i] = Integer.MAX_VALUE;
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        graph.get(source).add(edge);

        edge = new Edge(destination, source, weight);
        graph.get(destination).add(edge);
    }

    int num = 0;

    public void primMST() {
        // 创建一个优先队列，用于存储节点对象
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 将起始节点的键值设为0，并将其添加到优先队列中
        key[0] = 0;
        pq.offer(new Node(0, 0));

        // 当优先队列不为空时，执行循环
        while (!pq.isEmpty()) {
            // 取出队列中键值最小的节点
            int u = pq.poll().vertex;
            visited[u] = true;

            // 遍历节点u的所有邻居边
            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                // 如果节点v未被访问且边的权重小于节点v的键值
                if (!visited[v] && weight < key[v]) {
                    // 更新节点v的父节点为u，键值为边的权重，并将其添加到优先队列中
                    parent[v] = u;
                    key[v] = weight;
                    pq.offer(new Node(v, key[v]));
                    num++;
                }
            }
        }

        // 打印最小生成树
        printMST();
    }

    private void printMST() {
        System.out.println("Minimum Spanning Tree:");  // 最小生成树
        System.out.println("时间复杂度：" + num);
        for (int i = 1; i < graph.size(); i++) {
            System.out.println(parent[i] + " - " + i);  // 输出边的起点和终点
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        PrimAlgorithm prim = new PrimAlgorithm(vertices);

        prim.addEdge(0, 1, 4);
        prim.addEdge(0, 2, 3);
        prim.addEdge(1, 2, 1);
        prim.addEdge(1, 4, 2);
        prim.addEdge(1, 5, 9);
        prim.addEdge(1, 3, 2);
        prim.addEdge(2, 3, 4);
        prim.addEdge(2, 4, 8);
        prim.addEdge(2, 5, 9);
        prim.addEdge(3, 4, 2);
        prim.addEdge(4, 5, 6);

        prim.primMST();
    }
}


