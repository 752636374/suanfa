package 牛客网.一期.teacher.class_06;

import java.util.*;

//undirected graph only
//仅无向图

/**
 *  目的：最小代价生成树,
 *  Kruskal算法是一种用来寻找最小生成树的算法，由Joseph Kruskal在1956年发表。用来解决同样问题的还有Prim算法和Boruvka算法等。三种算法都是贪婪算法的应用。和Boruvka算法不同的地方是，Kruskal算法在图中存在相同权值的边时也有效。
 *
 * 2.算法简单描述
 *
 * 1).记Graph中有v个顶点，e个边
 *
 * 2).新建图Graphnew，Graphnew中拥有原图中相同的e个顶点，但没有边
 *
 * 3).将原图Graph中所有e个边按权值从小到大排序
 *
 * 4).循环：从权值最小的边开始遍历每条边 直至图Graph中所有的节点都在同一个连通分量中
 *
 *                 if 这条边连接的两个节点于图Graphnew中不在同一个连通分量中
 *
 *                                          添加这条边到图Graphnew中
 */

public class Code_04_Kruskal {

	// Union-Find Set
	public static class UnionFind {
		private HashMap<Node, Node> fatherMap;
		private HashMap<Node, Integer> rankMap;

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		private Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				rankMap.put(node, 1);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) {
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}


	public static Set<Edge> kruskalMST(Graph graph) {
		UnionFind unionFind = new UnionFind();
		unionFind.makeSets(graph.nodes.values());
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		for (Edge edge : graph.edges) {
			priorityQueue.add(edge);
		}
		Set<Edge> result = new HashSet<>();
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			if (!unionFind.isSameSet(edge.from, edge.to)) {
				result.add(edge);
				unionFind.union(edge.from, edge.to);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.nodes = getNodes();
		graph.edges = getEdges(graph.nodes);
	}

	private static HashSet<Edge> getEdges(HashMap<Integer, Node> map) {

		return null;
	}

	private static HashMap<Integer, Node> getNodes() {
		return getNods(1,1,2);
	}

	private static HashMap<Integer, Node> getNods(Integer length,Integer... as) {
		HashMap<Integer,Node> map = new HashMap<>();
		for(int i =0;i<length;i++){
			for(int j=0;j<as.length;j++){
				as[j] = (i+1)*as[j]*10;
			}
			ArrayList<Node> list = getArrayList(as);
			for(Node node:list){
				map.put(node.value,node);
			}
		}

		return map;
	}

	private static ArrayList<Node> getArrayList(Integer ... a) {
		ArrayList<Node> list = new ArrayList<>();
		for(Integer i:a){
			list.add(new Node(i));
		}
		return list;
	}
}
