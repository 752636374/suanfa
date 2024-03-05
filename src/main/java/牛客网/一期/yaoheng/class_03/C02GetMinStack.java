package 牛客网.一期.yaoheng.class_03;

import java.util.Stack;

public class C02GetMinStack {

    public static class GetMinStack {
        private Stack<Integer> stacks;
        private Stack<Integer> mins;
        int size;

        public GetMinStack() {
            stacks = new Stack();
            mins = new Stack();
            this.size = 0;
        }
        public int pop(){
            if(size==0){
                throw new RuntimeException("没有数据");
            }
            mins.pop();
            return stacks.pop();
        }


        public void add(int num) {
            if (size == 0) {
                mins.push(num);
                stacks.push(num);
            } else if (num < getMin()) {
                mins.push(num);
                stacks.push(num);
            } else {
                mins.push(getMin());
                stacks.push(num);
            }
            size++;
        }

        public int getMin() {
          return mins.peek();
        }
    }


    public static void main(String[] args) {
        GetMinStack getMinStack = new GetMinStack();
        getMinStack.add(2);
        getMinStack.add(3);
        getMinStack.add(1);
        System.out.println(getMinStack.getMin()==1);

        getMinStack.pop();
        System.out.println(getMinStack.getMin()==2);
    }
}
