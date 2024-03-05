package 牛客网.一期.teacher.class_06;

import java.util.*;

/**
 * 广度优先
 * 采用队列实现：
 */
public class Code_01_BFS {

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
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
		bfs(node);

    }

	private static ArrayList<Node> getArrayList(Integer ... a) {
		ArrayList<Node> list = new ArrayList<>();
		for(Integer i:a){
			list.add(new Node(i));
		}
		return list;
	}


}
