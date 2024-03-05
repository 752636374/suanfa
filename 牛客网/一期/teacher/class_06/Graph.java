package 牛客网.一期.teacher.class_06;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图形
 */
public class Graph {
	public HashMap<Integer,Node> nodes;
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
