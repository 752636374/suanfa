package 牛客网.一期.yaoheng.class_03;

import java.util.HashMap;
import java.util.Map;

public class C13CopyListWithRandom {
    static class MyNode {
        private Integer num;
        private MyNode next;
        private MyNode random;

        public MyNode(Integer num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.random = node4;
        node2.random = node3;
        node3.random = node1;
        node4.random = null;

        printNode(node1);
        MyNode myNode = copyListWithRandom1(node1);
        printNode(myNode);
    }

    private static MyNode copyListWithRandom1(MyNode node1) {
        Map<MyNode, MyNode> map = new HashMap<>();
        MyNode m = node1;
        while (m != null) {
            map.put(m, new MyNode(m.num));
            m = m.next;
        }

        MyNode res = node1;
        while (res != null) {
            map.get(res).next = res.next;
            map.get(res).random = res.random;
            res = res.next;
        }
        res = map.get(node1);
        return res;
    }

    private static void printNode(MyNode node1) {
        MyNode myNode = node1;
        System.out.print("next:" + "\t");
        while (myNode != null) {
            System.out.print(myNode.num + "\t");
            myNode = myNode.next;
        }
        System.out.println();
        System.out.print("random:" + "\t");
        myNode = node1;
        while (myNode != null) {
            System.out.print(myNode.random == null ? ("-" + "\t") : (myNode.random.num + "\t"));
            myNode = myNode.next;
        }
        System.out.println();

    }
}
