package 牛客网.一期.yaoheng.class_03;

public class C01ArrayToStackQueue {
    public static class ArrayToQueue {
        private int[] as;
        private int start;
        private int end;
        private int size;

        public ArrayToQueue(int size) {
            as = new int[size];
            start = 0;
            end = 0;
            this.size = 0;
        }

        public void add(int num) {
            if (size == as.length) {
                throw new RuntimeException("数据已满");
            }
            if (start == as.length - 1) {
                start = 0;
                as[start] = num;
                size++;
                return;
            }
            as[start++] = num;
            size++;
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("没有数据");
            }
            if (end == as.length - 1) {
                int result = as[end];
                end = 0;
                size--;
                return result;
            }
            size--;
            return as[end++];
        }


    }

    public static class ArrayToStack {
        private int[] as;
        private int size;

        public ArrayToStack(int size) {
            this.size = 0;
            as = new int[size];
        }

        public void add(int num) {
            if (size == as.length) {
                throw new RuntimeException("数据已满");
            }
            as[size++] = num;
        }

        public int pull() {
            if (size == 0) {
                throw new RuntimeException("数据为空！");
            }
            return as[--size];
        }
    }


    public static void main(String[] args) {
//        ArrayToQueue arrayToQueue = new ArrayToQueue(10);
//        arrayToQueue.add(1);
//        System.out.println(arrayToQueue.pop()==1);


//        ArrayToQueue arrayToQueue3 = new ArrayToQueue(1);
//        arrayToQueue3.pop();

        ArrayToStack arrayToStack = new ArrayToStack(2);
        arrayToStack.add(2);
        System.out.println(arrayToStack.pull() == 2);

    }
}
