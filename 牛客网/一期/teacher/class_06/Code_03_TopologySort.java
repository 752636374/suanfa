package 牛客网.一期.teacher.class_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序
 *
 * 从 DAG 图中选择一个 没有前驱（即入度为0）的顶点并输出。
 * 从图中删除该顶点和所有以它为起点的有向边。
 * 重复 1 和 2 直到当前的 DAG 图为空或当前图中不存在无前驱的顶点为止。后一种情况说明有向图中必然存在环。
 */
public class Code_03_TopologySort {

	// directed graph and no loop
	//有向图且无循环
	public static List<Node> sortedTopology(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<>();
		Queue<Node> zeroInQueue = new LinkedList<>();
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}
		List<Node> result = new ArrayList<>();
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			result.add(cur);
			for (Node next : cur.nexts) {
				inMap.put(next, inMap.get(next) - 1);
				if (inMap.get(next) == 0) {
					zeroInQueue.add(next);
				}
			}
		}
		return result;
	}





	public static void main(String[] args) {
		Graph graph =new Graph();
		graph.nodes = getNods(3,1,2);
		List<Node> list = sortedTopology(graph);
		for(Node node :list){
			System.out.println(node.value);
		}
	}

	private static HashMap<Integer, Node> getNods(Integer length,Integer... as) {
		HashMap<Integer,Node> map = new HashMap<>();
		for(int i =0;i<length;i++){
			for(int j=0;j<as.length;j++){
				as[j] = (i+1)*as[j]*19;
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
