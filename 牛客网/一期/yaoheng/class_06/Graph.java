package 牛客网.一期.yaoheng.class_06;

import java.util.ArrayList;
import java.util.List;

class Graph {
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        // 标记当前顶点为已访问
        visited[vertex] = true;
        // 标记当前顶点在递归栈中
        recursionStack[vertex] = true;

        // 获取当前顶点的邻居列表
        List<Integer> neighbors = adjacencyList.get(vertex);
        // 遍历邻居列表
        for (int neighbor : neighbors) {
            // 如果邻居顶点未被访问且在递归栈中存在环，则返回 true
            if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recursionStack)) {
                return true;
            }
            // 如果邻居顶点在递归栈中存在环，则返回 true
            else if (recursionStack[neighbor]) {
                return true;
            }
        }

        // 当前顶点的邻居都被访问过，标记当前顶点不在递归栈中
        recursionStack[vertex] = false;
        // 没有找到环，返回 false
        return false;
    }


    public boolean isCyclic() {
        boolean[] visited = new boolean[numVertices]; // 用于标记顶点是否被访问过
        boolean[] recursionStack = new boolean[numVertices]; // 用于检测是否存在环

        for (int i = 0; i < numVertices; i++) { // 遍历所有顶点
            if (!visited[i] && isCyclicUtil(i, visited, recursionStack)) { // 如果顶点未被访问且存在环
                return true; // 返回true，表示图中存在环
            }
        }

        return false; // 返回false，表示图中不存在环
    }


    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        boolean hasCycle = graph.isCyclic();
        System.out.println("Does the graph have a cycle? " + hasCycle);
    }
}
