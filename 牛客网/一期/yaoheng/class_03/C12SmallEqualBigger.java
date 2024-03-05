package 牛客网.一期.yaoheng.class_03;

public class C12SmallEqualBigger {
    static class MyNode {
        private Integer num;
        private MyNode next;

        public MyNode(Integer num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        MyNode head = new MyNode(1);
        head.next = new MyNode(2);
        head.next.next = new MyNode(9);
        head.next.next.next = new MyNode(10);
        head.next.next.next.next = new MyNode(7);
        head.next.next.next.next.next = new MyNode(6);
        head.next.next.next.next.next.next = new MyNode(3);
        printNode(head);
        head = smallEqualBigger(head, 3);
        printNode(head);
    }

    private static MyNode smallEqualBigger(MyNode head, int number) {

        //分为三个桶
        MyNode sm = null;
        MyNode st = null;
        MyNode em = null;
        MyNode et = null;
        MyNode lm = null;
        MyNode lt = null;


        MyNode cur = head;
        MyNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.num < number) {
                if (sm == null) {
                    sm = cur;
                    st = cur;
                } else {
                    st.next = cur;
                    st = cur;
                }
            } else if (cur.num == number) {
                if (em == null) {
                    em = cur;
                    et = cur;
                } else {
                    et.next = cur;
                    et = cur;
                }
            } else {
                if (lm == null) {
                    lm = cur;
                    lt = cur;
                } else {
                    lt.next = cur;
                    lt = cur;
                }
            }
            cur = next;
        }


        //合并数据
        if (st != null) {
            st.next = em;
            et = et == null ? st : et;
        }
        if (et != null) {
            et.next = lm;
        }

        return sm != null ? sm : em != null ? em : lm;
    }

    private static void printNode(MyNode head) {
        MyNode sout = head;
        while (sout != null) {
            System.out.print(sout.num + "\t");
            sout = sout.next;
        }
        System.out.println();
    }
}
