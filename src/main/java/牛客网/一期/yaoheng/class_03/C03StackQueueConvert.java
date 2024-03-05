package 牛客网.一期.yaoheng.class_03;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class C03StackQueueConvert {
    public static class StackToQueue {
        private Stack<Integer> pull = new Stack<>();
        private Stack<Integer> pop = new Stack<>();
        private int size;

        public void push(Integer num) {
            pull.push(num);
            size++;
        }

        public Integer pop() {
            if (!pop.isEmpty()) {
                size--;
                return pop.pop();
            }
            if (pull.isEmpty()) {
                throw new RuntimeException("数据为空");
            }

            while (!(pull.size() == 1)) {
                pop.push(pull.pop());
            }
            int result = pull.pop();
            size--;
            return result;
        }

        public Integer size() {
            return size;
        }

        public Integer peek() {
            if (!pop.isEmpty()) {
                return pop.peek();
            }
            if (pull.isEmpty()) {
                throw new RuntimeException("数据为空");
            }

            while (pull.size() > 0) {
                pop.push(pull.pop());
            }
            int result = pop.peek();
            return result;
        }
    }


    public static class QueueToStack {
        private Queue<Integer> pull = new LinkedBlockingDeque<>();
        private Queue<Integer> pop = new LinkedBlockingDeque<>();

        public void pull(Integer num) {
            pull.add(num);
        }

        public Integer pop() {
            if (pull.isEmpty()) {
                throw new RuntimeException("data is null");
            }

            while (pull.size() > 1) {
                pop.add(pull.poll());
            }
            int result = pull.poll();
            swapData();
            return result;
        }

        private void swapData() {
            Queue<Integer> swap = pull;
            pull = pop;
            pop = swap;
        }

        public Integer peek() {
            if (pull.isEmpty()) {
                throw new RuntimeException("data is null");
            }

            while (pull.size() > 1) {
                pop.add(pull.poll());
            }
            int result = pull.poll();
            pop.add(result);
            swapData();
            return result;
        }
    }


    public static void main(String[] args) {
        testStackToQueue();
        testQueueToStack();
    }

    private static void testQueueToStack() {
        System.out.println("testQueueToStack");
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.pull(1);
        queueToStack.pull(2);
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.pop());
        queueToStack.pull(1);
        queueToStack.pull(2);
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.pop());
    }

    private static void testStackToQueue() {
        System.out.println("testStackToQueue");
        StackToQueue stack = new StackToQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (stack.size > 0) {
            System.out.println(stack.pop());
        }
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }
}
