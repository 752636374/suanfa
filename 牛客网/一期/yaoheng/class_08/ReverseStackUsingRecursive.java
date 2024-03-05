package 牛客网.一期.yaoheng.class_08;

import java.util.Stack;

public class ReverseStackUsingRecursive {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);

        System.out.println(num);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return; // 递归终止条件，栈为空
        }

        int temp = stack.pop(); // 递归处理的关键步骤，将栈顶元素取出

        reverseStack(stack); // 递归调用，反转剩余栈中的元素

        insertAtBottom(stack, temp); // 将取出的元素插入到栈底
    }
    static int num=0;
    private static void insertAtBottom(Stack<Integer> stack, int value) {
        num++;
        if (stack.isEmpty()) {
            stack.push(value); // 栈为空，直接将元素插入到栈底
        } else {
            int temp = stack.pop(); // 取出栈顶元素
            insertAtBottom(stack, value); // 递归调用，将元素插入到剩余栈中
            stack.push(temp); // 将之前取出的栈顶元素重新插入到栈顶
        }
    }
}
