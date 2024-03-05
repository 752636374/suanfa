package 牛客网.一期.yaoheng.class_06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Code_01_BFS_yh {

    public static void main(String[] args) {
        Node node = new Node(1);
        bfs(node);
    }

    private static void bfs(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> set   = new HashSet<>();
        stack.add(node);
        while (!stack.isEmpty()){
            Node node1 = stack.pop();
            System.out.println(node1.getNum());
            set.add(node1);
            List<Node> list = node1.getNest();
            if(list!= null && list.size()>0){
                for(Node node2:list){
                    stack.push(node2);
                }
            }
        }
    }
}
