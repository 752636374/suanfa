package 牛客网.一期.teacher.class_06;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// undirected graph only
//仅无向图

/**
 * 1).输入：一个加权连通图，其中顶点集合为V，边集合为E；
 *
 * 2).初始化：Vnew = {x}，其中x为集合V中的任一节点（起始点），Enew = {},为空；
 *
 * 3).重复下列操作，直到Vnew = V：
 *
 * a.在集合E中选取权值最小的边<u, v>，其中u为集合Vnew中的元素，而v不在Vnew集合当中，并且v∈V（如果存在有多条满足前述条件即具有相同权值的边，则可任意选取其中之一）；
 *
 * b.将v加入集合Vnew中，将<u, v>边加入集合Enew中；
 *
 * 4).输出：使用集合Vnew和Enew来描述所得到的最小生成树
 *
 */
public class Code_05_Prim {

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> primMST(Graph graph) {
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
				new EdgeComparator());
		HashSet<Node> set = new HashSet<>();
		Set<Edge> result = new HashSet<>();
		for (Node node : graph.nodes.values()) {
			if (!set.contains(node)) {
				set.add(node);
				for (Edge edge : node.edges) {
					priorityQueue.add(edge);
				}
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll();
					Node toNode = edge.to;
					if (!set.contains(toNode)) {
						set.add(toNode);
						result.add(edge);
						for (Edge nextEdge : toNode.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
	}

}
