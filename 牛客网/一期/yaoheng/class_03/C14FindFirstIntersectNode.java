package 牛客网.一期.yaoheng.class_03;

public class C14FindFirstIntersectNode {
    static class MyNode {
        private Integer num;
        private MyNode next;

        public MyNode(Integer num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        node1.next = new MyNode(2);
        node1.next.next = new MyNode(4);
        node1.next.next.next = new MyNode(5);
        node1.next.next.next.next = new MyNode(6);
        node1.next.next.next.next.next = new MyNode(7);

        MyNode node2 = new MyNode(1);
        node2.next = new MyNode(2);
        node2.next.next = new MyNode(4);
        node2.next.next.next = new MyNode(5);
        node2.next.next.next.next = new MyNode(6);
        node2.next.next.next.next.next = new MyNode(7);
        node2.next.next.next.next.next.next = node1.next.next;

        MyNode cur = getFirstIntersectNode(node1, node2);
        if (cur != null) {
            System.out.println(cur.num);
        }


        node1 = new MyNode(1);
        node1.next = new MyNode(2);
        node1.next.next = new MyNode(4);
        node1.next.next.next = new MyNode(5);
        node1.next.next.next.next = new MyNode(6);
        node1.next.next.next.next.next = new MyNode(7);
        node1.next.next.next.next.next.next = node1.next.next;

        node2 = new MyNode(1);
        node2.next = new MyNode(2);
        node2.next.next = new MyNode(4);
        node2.next.next.next =new MyNode(5);
        node2.next.next.next.next = new MyNode(6);
        node2.next.next.next.next.next = new MyNode(7);
        node2.next.next.next.next.next.next = node1.next.next.next;

        cur = getFirstIntersectNode(node1, node2);
        if (cur != null) {
            System.out.println(cur.num);
        }


    }

    private static MyNode getFirstIntersectNode(MyNode node1, MyNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        MyNode loopNode1 = getLoopNode(node1);
        MyNode loopNode2 = getLoopNode(node2);
        //两个直线相交
        if (loopNode1 == null && loopNode2 == null) {
            return noLoop(node1, node2);
        }
        //两个圆相交
        if (loopNode1 != null && loopNode2 != null) {
            return bothLoop(node1, loopNode1, node2, loopNode2);
        }
        return null;

    }

    private static MyNode bothLoop(MyNode node1, MyNode loopNode1, MyNode node2, MyNode loopNode2) {
        //交点在同一个点，往上找寻交点
        if (loopNode1 == loopNode2) {
            int n = 0;
            MyNode c1 = node1;
            while (c1 != loopNode1) {
                n++;
                c1 = c1.next;
            }

            MyNode c2 = node2;
            while (c2 != loopNode2) {
                n--;
                c2 = c2.next;
            }

            c1 = n > 0 ? node1 : node2;
            c2 = c1 == node1 ? node2 : node1;

            n = Math.abs(n);
            while (n > 0) {
                c1 = c1.next;
                n--;
            }

            while (c1 != c2) {
                c1 = c1.next;
                c2 = c2.next;
            }
            return c1;

        }
        //交点在圆环上
        else {
            MyNode c1 = loopNode1.next;
            while (c1 != loopNode1) {
                if (c1 == loopNode2) {
                    return loopNode1;
                }
                c1 = c1.next;
            }
            return null;
        }
    }

    /**
     * 1、各自都到最后一位，最后一位相等则有相聚的点
     * 2、获取数据相差的长度n
     * 3、先走长度n
     * 4、同时走，相等则是交点
     *
     * @param node1
     * @param node2
     * @return
     */
    private static MyNode noLoop(MyNode node1, MyNode node2) {
        //判定两个最终节点是否是同一个
        MyNode cur1 = node1;
        MyNode cur2 = node2;
        while (cur1.next != null) {
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        //获取差值
        int n = 0;
        cur1 = node1;
        cur2 = node2;
        while (cur1 != null) {
            cur1 = cur1.next;
            n++;
        }

        while (cur2 != null) {
            cur2 = cur2.next;
            n--;
        }

        cur1 = n > 0 ? node1 : node2;
        cur2 = cur1 == node1 ? node2 : node1;

        n = Math.abs(n);
        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1 != null) {
            return cur1;
        }
        return null;
    }

    /**
     * 分快慢两补，如果能够有相等的点，那么就是环装
     *
     * @param node1
     * @return
     */
    private static MyNode getLoopNode(MyNode node1) {
        if (node1 == null || node1.next == null || node1.next.next == null) {
            return null;
        }
        MyNode myNode1 = node1.next;
        MyNode myNode2 = node1.next.next;
        while (myNode1 != myNode2) {
            if (myNode1 == null || myNode2 == null) {
                return null;
            }
            if (myNode2.next == null || myNode2.next.next == null) {
                return null;
            }
            myNode1 = myNode1.next;
            myNode2 = myNode2.next.next;
        }

        myNode2 = node1;
        while (myNode1 != myNode2) {
            myNode1 = myNode1.next;
            myNode2 = myNode2.next;
        }
        return myNode2;
    }
}
