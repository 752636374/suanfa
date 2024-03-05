package 牛客网.一期.yaoheng.class_03;

public class C10PrintCommonPart {
    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        node1.next = new MyNode(2);
        node1.next.next = new MyNode(3);
        node1.next.next.next = new MyNode(4);

        MyNode node2 = new MyNode(2);
        node2.next = new MyNode(3);
        node2.next.next = new MyNode(4);
        node2.next.next.next = new MyNode(5);

        printNode(node1);
        printNode(node2);

        printCommonPart(node1, node2);

    }

    private static void printCommonPart(MyNode node1, MyNode node2) {
        while (node1 != null && node2 != null) {
            if (node1.index > node2.index) {
                node2 = node2.next;
            } else if (node1.index < node2.index) {
                node1 = node1.next;
            } else {
                System.out.print(node1.index);
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }

    private static void printNode(MyNode node1) {
        MyNode node = node1;
        while (node != null) {
            System.out.print(node.index + "\t");
            node = node.next;
        }
        System.out.println();
    }

    static class MyNode {
        private Integer index;
        private MyNode next;

        public MyNode(Integer index) {
            this.index = index;
        }
    }
}
