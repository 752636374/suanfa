package 牛客网.一期.yaoheng.class_03;

public class C07ReverseLsit {

    static class MyNode {
        private Integer name;
        private MyNode next;

        public MyNode(Integer name) {
            this.name = name;
        }

        public Integer getName() {
            return name;
        }

        public void setName(Integer name) {
            this.name = name;
        }

        public MyNode getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "name=" + name +
                    '}';
        }
    }


    public static void main(String[] args) {
        MyNode myNode = new MyNode(1);
        MyNode myNode2 = new MyNode(2);
        MyNode myNode3 = new MyNode(3);
        myNode.setNext(myNode2);
        myNode2.setNext(myNode3);

        printNode(myNode);
        myNode = revertNode(myNode);
        printNode(myNode);


        MyDoubleNode myDoubleNode1 = new MyDoubleNode(1);
        myDoubleNode1.next = new MyDoubleNode(2);
        myDoubleNode1.next.pre = myDoubleNode1;
        myDoubleNode1.next.next = new MyDoubleNode(3);
        myDoubleNode1.next.next.pre = myDoubleNode1.next;
        myDoubleNode1.next.next.next = new MyDoubleNode(4);
        myDoubleNode1.next.next.next.pre = myDoubleNode1.next.next;

        printNode(myDoubleNode1);
        myDoubleNode1 = revertNode(myDoubleNode1);
        printNode(myDoubleNode1);

    }

    private static MyDoubleNode revertNode(MyDoubleNode myDoubleNode1) {
        if (myDoubleNode1 == null) {
            return null;
        }

        MyDoubleNode pre = myDoubleNode1.pre;
        MyDoubleNode current = myDoubleNode1;
        MyDoubleNode next = myDoubleNode1.next;

        while (current != null) {
            current.next = pre;
            current.pre = next;
            pre = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        return pre;
    }

    private static void printNode(MyDoubleNode myDoubleNode1) {
        if (myDoubleNode1 == null) {
            return;
        }
        MyDoubleNode mPre = myDoubleNode1.pre;
        MyDoubleNode m = myDoubleNode1;

        while (m != null) {
            System.out.print(m.num + "\t");
            mPre = m;
            m = m.next;
        }

        System.out.print("|" + "\t");
        m = mPre;
        while (m != null) {
            System.out.print(m.num + "\t");
            m = m.pre;
        }

        System.out.println();
    }

    static class MyDoubleNode {
        private int num;
        private MyDoubleNode pre;
        private MyDoubleNode next;

        public MyDoubleNode(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "MyDoubleNode{" +
                    "num=" + num +
                    '}';
        }
    }

    private static MyNode revertNode(MyNode myNode) {
        if (myNode == null) {
            return myNode;
        }
        MyNode now = myNode;
        MyNode next = myNode.next;
        MyNode pre = null;

        while (now != null) {
            now.next = pre;
            pre = now;
            now = next;
            if (next != null) {
                next = next.next;
            }
        }
        return pre;
    }

    private static void printNode(MyNode myNode) {
        if (myNode == null) {
            return;
        }
        if (myNode != null) {
            System.out.print(myNode.getName() + "\t");
        }
        while (myNode.next != null) {
            myNode = myNode.next;
            System.out.print(myNode.getName() + "\t");
        }
        System.out.println();
    }
}
