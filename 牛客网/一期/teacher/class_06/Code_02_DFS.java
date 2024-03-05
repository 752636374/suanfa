package 牛客网.一期.teacher.class_06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先
 * 采用栈实现
 */
public class Code_02_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}



	public static void main(String[] args) {
		Node node = new Node(1);
		ArrayList<Node> list = getArrayList(2,3);
		node.nexts =list;
		node.nexts.get(0).nexts=getArrayList(4,5);
		node.nexts.get(1).nexts=getArrayList(6,7);
		dfs(node);

	}

	private static ArrayList<Node> getArrayList(Integer ... a) {
		ArrayList<Node> list = new ArrayList<>();
		for(Integer i:a){
			list.add(new Node(i));
		}
		return list;
	}


}
