package 牛客网.一期.yaoheng.class_06;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 适合密集图，
 */
public class PrimAlgorithm_yh {
    //边，起点，重点，权重
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    //节点，节点编号，节点权重，实现比较接口
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }

    //图的邻接表示法，父节点信息，是否访问信息，节点权重
    List<List<Edge>> graph;//图
    int[] parent;//父节点
    boolean[] visited;//是否访问
    int[] key;//权重

    //方法：添加节点，求最小生成树，打印


    public PrimAlgorithm_yh(int vertices) {
        graph = new ArrayList<>(vertices);
        parent = new int[vertices];
        visited = new boolean[vertices];
        key = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
            key[i] = Integer.MAX_VALUE;
        }
    }


    public static void main(String[] args) {
        //建立图
        int vertices = 6;
        PrimAlgorithm_yh prim = new PrimAlgorithm_yh(vertices);
        //新增对象

        prim.addEdge(0, 1, 4);
        prim.addEdge(0, 2, 3);
        prim.addEdge(1, 2, 1);
        prim.addEdge(1, 3, 2);
        prim.addEdge(2, 3, 4);
        prim.addEdge(3, 4, 2);
        prim.addEdge(4, 5, 6);

        //打印最小生成树
        prim.primMst(4);
    }

    private void primMst(int index) {
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        key[index] = 0;
        nodes.add(new Node(index, 0));

        while (!nodes.isEmpty()) {
            int vertex = nodes.poll().vertex;
            visited[vertex] = true;

            for (Edge edge : graph.get(vertex)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (!visited[v] && weight < key[v]) {
                    parent[v] = vertex;
                    key[v] = weight;
                    nodes.add(new Node(v, key[v]));
                }
            }
        }
        printMst();
    }

    private void printMst() {
        System.out.println("Mininum spanning Tree ");
        for (int i = 1; i < graph.size(); i++) {
            System.out.println(parent[i] + "-" + i);
        }
    }

    private void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        graph.get(source).add(edge);

        edge = new Edge(destination, source, weight);
        graph.get(destination).add(edge);
    }
}
