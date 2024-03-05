package 牛客网.一期.yaoheng.class_06;

import java.util.Arrays;

public class Dijkstra_yh {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1, 2, 3},
                {1, 0, 2, 0, 4, 0},
                {0, 2, 0, 0, 4, 0},
                {1, 0, 2, 0, 4, 0},
                {2, 4, 4, 4, 0, 0},
                {3, 0, 0, 0, 0, 0}
        };
        int startNode = 0;
        int[] shortDistances = dijkstar(graph, startNode);
        System.out.println("节点\t距离");
        for (int i = 0; i < shortDistances.length; i++) {
            System.out.println(i + "\t" + shortDistances[i]);
        }
    }

    private static int[] dijkstar(int[][] graph, int startNode) {
        int length = graph.length;//长度
        int[] dist = new int[length];//节点到其他节点的最短距离
        boolean[] visited = new boolean[length];//是否已经访问

        Arrays.fill(dist, Integer.MAX_VALUE);//初始化数据为最大值

        //初始化最小值
        dist[startNode] = 0;//设置开始节点的距离值为0


        for (int i = 0; i < length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            //选择距离最小的节点作为当前节点
            for (int v = 0; v < length; v++) {
                if (!visited[v] && dist[v] < min) {
                    min = dist[v];
                    minIndex = v;
                }
            }

            //设置为已经访问
            visited[minIndex] = true;

            //标记距离当前节点最近的节点
            for (int v = 0; v < length; v++) {
                //条件，没有访问，值不为MaxValue,和小于当前值，当前值不为0
                if (graph[i][v] != 0 &&
                        !visited[v] &&
                        dist[minIndex] != Integer.MAX_VALUE &&
                        dist[minIndex] + graph[minIndex][v] < dist[v])
                    dist[v] = dist[minIndex] + graph[minIndex][v];
            }
        }

        return dist;
    }
}
