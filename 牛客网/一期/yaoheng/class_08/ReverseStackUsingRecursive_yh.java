package 牛客网.一期.yaoheng.class_08;

import java.util.Stack;

public class ReverseStackUsingRecursive_yh {
    public static void main(String[] args) {
        //初始化数据
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("original stack:" + stack);
        reverseStack(stack);
        System.out.println("reverse stack:" + stack);

    }

    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer num = stack.pop();
        reverseStack(stack);
        insertToBottom(stack, num);//将数据插入到栈底
    }

    private static void insertToBottom(Stack<Integer> stack, Integer num) {
        if (stack.isEmpty()) {
            //栈为空直接插入到栈底
            stack.push(num);
        } else {
            //栈不为空，取出数据，插入到栈底
            int temp = stack.pop();
            insertToBottom(stack, num);
            stack.push(temp);
        }
    }

}
