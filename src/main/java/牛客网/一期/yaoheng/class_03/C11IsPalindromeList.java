package 牛客网.一期.yaoheng.class_03;

import java.util.Stack;

public class C11IsPalindromeList {
    static class MyNode {
        private Integer num;
        private MyNode next;

        public MyNode(Integer num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        //奇数-对称
        MyNode node1 = new MyNode(1);
        node1.next = new MyNode(2);
        node1.next.next = new MyNode(3);
        node1.next.next.next = new MyNode(2);
        node1.next.next.next.next = new MyNode(1);
        System.out.println(isPalindromeList1(node1));
        System.out.println(isPalindromeList2(node1));
        System.out.println(isPalindromeList3(node1));
        System.out.println("=========================");

        //偶数-对称
        MyNode node3 = new MyNode(1);
        node3.next = new MyNode(2);
        node3.next.next = new MyNode(3);
        node3.next.next.next = new MyNode(3);
        node3.next.next.next.next = new MyNode(2);
        node3.next.next.next.next.next = new MyNode(1);
        System.out.println(isPalindromeList1(node3));
        System.out.println(isPalindromeList2(node3));
        System.out.println(isPalindromeList3(node3));
        System.out.println("=========================");

        //不对称
        MyNode node2 = new MyNode(1);
        node2.next = new MyNode(2);
        node2.next.next = new MyNode(3);
        node2.next.next.next = new MyNode(2);
        System.out.println(isPalindromeList1(node2));
        System.out.println(isPalindromeList2(node2));
        System.out.println(isPalindromeList3(node2));
    }

    /**
     * 多费 n/2 的空间
     *
     * @param node1
     * @return
     */
    private static boolean isPalindromeList3(MyNode node1) {
        MyNode myNode = node1;
        MyNode n1 = node1;
        MyNode n2 = node1.next;
        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        Stack<MyNode> stack = new Stack<>();
        while (n1.next != null) {
            stack.add(n1.next);
            n1.next = n1.next.next;
        }

        while (stack.size() != 0) {
            if (myNode.num != stack.pop().num) {
                return false;
            }
            myNode = myNode.next;
        }
        return true;
    }

    /**
     * @param node1
     * @return
     */
    private static boolean isPalindromeList2(MyNode node1) {
        Stack<MyNode> stack = new Stack<>();
        MyNode myNode = node1;
        while (myNode != null) {
            stack.add(myNode);
            myNode = myNode.next;
        }

        myNode = node1;
        while (stack.size() != 0) {
            if (stack.pop().num != myNode.num) {
                return false;
            }
            myNode = myNode.next;
        }
        return true;
    }

    private static boolean isPalindromeList1(MyNode node1) {
        //获取中间node位置
        MyNode n1 = node1;
        MyNode n2 = node1.next;
        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        //中间位置后的数据倒序
        MyNode before = null;
        MyNode cur = n1;
        MyNode next = n1.next;

        while (cur != null) {
            cur.next = before;
            before = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }

        //从两头比较数据是否相等
        MyNode last = before;
        MyNode first = node1;
        boolean result = true;
        while (first != null) {
            if (first.num != last.num) {
                result = false;
            }
            first = first.next;
            last = last.next;
        }

        //数据位置复原
        MyNode beforeB = before.next;
        MyNode curB = before;
        MyNode nextB = null;
        while (curB != null) {
            curB.next = nextB;
            nextB = curB;
            curB = beforeB;
            if (beforeB != null) {
                beforeB = beforeB.next;
            }
        }

        return result;
    }

}
