package 牛客网.一期.yaoheng.class_06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Code_02_DFS_yh {
    public static void main(String[] args) {
        Node node = new Node(1);
        dfs(node);
    }

    private static void dfs(Node node) {
        // 创建一个空的集合，用于存储已访问过的节点
        Set<Node> set = new HashSet<>();

        // 创建一个栈，并将初始节点压入栈中
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        // 当栈不为空时，循环执行以下操作
        while (!stack.isEmpty()) {
            // 从栈中弹出一个节点
            Node node1 = stack.pop();

            // 将弹出的节点添加到已访问集合中
            set.add(node1);

            // 获取当前节点的嵌套列表
            List<Node> list = node1.getNest();

            // 如果嵌套列表不为空且长度大于0
            if (list != null && list.size() > 0) {
                // 遍历嵌套列表中的每个节点
                for (Node node2 : list) {
                    // 如果当前节点未被访问过
                    if (!set.contains(node2)) {
                        // 将当前节点和下一个节点压入栈中
                        stack.push(node1);
                        stack.push(node2);

                        // 将下一个节点添加到已访问集合中
                        set.add(node2);

                        // 打印下一个节点的数值
                        System.out.println(node2.getNum());

                        // 跳出当前循环，继续处理下一个节点
                        break;
                    }
                }
            }
        }
    }

}
