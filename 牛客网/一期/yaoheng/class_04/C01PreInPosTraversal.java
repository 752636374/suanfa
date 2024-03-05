package 牛客网.一期.yaoheng.class_04;

import java.util.Stack;

public class C01PreInPosTraversal {
    private static class MyNode {
        private Integer num;
        private MyNode left;
        private MyNode right;

        public MyNode(Integer num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        MyNode myNode = new MyNode(1);
        myNode.left = new MyNode(2);
        myNode.right = new MyNode(3);

        myNode.left.left = new MyNode(4);
        myNode.left.right = new MyNode(5);

        myNode.right.left = new MyNode(6);
        myNode.right.right = new MyNode(7);

        System.out.println("pre");
        preOrderRecur(myNode);
        System.out.println("\n" + "in");
        inOrderRecur(myNode);
        System.out.println("\n" + "post");
        postOrderRecur(myNode);

        System.out.println("\n" + "================================");

        System.out.println("\n" + "unpre");
        preOrderUnRecur(myNode);
        System.out.println("\n" + "unin");
        inOrderUnRecur(myNode);
        System.out.println("\n" + "unpost");
        postOrderUnRecur(myNode);

    }

    private static void postOrderUnRecur(MyNode myNode) {
        if (myNode == null) {
            return;
        }
        Stack<MyNode> stack1 = new Stack<>();
        stack1.add(myNode);
        MyNode node;
        MyNode nodePop = null;//记录弹出的数据，用于后续比较是否入栈或者是出栈
        while (!stack1.isEmpty()) {
            node = stack1.peek();
            if (node.left != null && node.left != nodePop && node.right != nodePop) {
                stack1.push(node.left);
            } else if (node.right != null && node.right != nodePop) {
                stack1.push(node.right);
            } else {
                System.out.print(stack1.pop().num + "\t");
                nodePop = node;
            }
        }

    }

    /**
     * 中间开始排序
     * 从左边开始添加数据，然后再添加右边的数据
     *
     * @param myNode
     */
    private static void inOrderUnRecur(MyNode myNode) {

        if (myNode == null) {
            return;
        }
        Stack<MyNode> stack = new Stack<>();
        MyNode node = myNode;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.num + "\t");
                node = node.right;
            }
        }

    }

    /**
     * 前序，拿到当前节点即可输出
     *
     * @param myNode
     */
    private static void preOrderUnRecur(MyNode myNode) {
        if (myNode == null) {
            return;
        }
        Stack<MyNode> stack = new Stack<>();
        stack.push(myNode);
        MyNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.num + "\t");
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    private static void postOrderRecur(MyNode myNode) {
        if (myNode == null) {
            return;
        }
        postOrderRecur(myNode.left);
        postOrderRecur(myNode.right);
        System.out.print(myNode.num + "\t");
    }

    private static void inOrderRecur(MyNode myNode) {
        if (myNode == null) {
            return;
        }
        inOrderRecur(myNode.left);
        System.out.print(myNode.num + "\t");
        inOrderRecur(myNode.right);
    }

    private static void preOrderRecur(MyNode myNode) {
        if (myNode == null) {
            return;
        }
        System.out.print(myNode.num + "\t");
        preOrderRecur(myNode.left);
        preOrderRecur(myNode.right);
    }
}
