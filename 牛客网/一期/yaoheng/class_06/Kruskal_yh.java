package 牛客网.一期.yaoheng.class_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal_yh {

    //边
    static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static class KruskalAlgorithm {
        //存储边
        List<Edge> edges;
        //存储父节点索引
        int[] parent;

        public KruskalAlgorithm(int vertices) {
            edges = new ArrayList<>(vertices);
            parent = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            edges.add(edge);
        }


        public List<Edge> kruskalMST() {
            List<Edge> miniSpanningTree = new ArrayList<>();
            Collections.sort(edges);
            for (Edge edge : edges) {
                int source = find(edge.source);
                int destination = find(edge.destination);
                if (source != destination) {
                    union(source, destination);
                    miniSpanningTree.add(edge);
                }
            }
            return miniSpanningTree;
        }

        private void union(int source, int destination) {
            parent[source] = destination;
        }

        private int find(int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]);
            }
            return parent[vertex];
        }
    }

    public static void main(String[] args) {
        //新建对象，克鲁斯卡尔算法
        int vertices = 6;
        KruskalAlgorithm kruskal = new KruskalAlgorithm(vertices);
        //添加数据
        kruskal.addEdge(0, 1, 3);
        kruskal.addEdge(1, 2, 3);
        kruskal.addEdge(2, 3, 3);
        kruskal.addEdge(3, 4, 3);
        kruskal.addEdge(3, 5, 3);
        kruskal.addEdge(4, 5, 3);
        //打印数据
        List<Edge> minimumSpanningTree = kruskal.kruskalMST();
        System.out.println("minimum spanning tree");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.source + "-" + edge.destination + ":" + edge.weight);
        }
    }
}
