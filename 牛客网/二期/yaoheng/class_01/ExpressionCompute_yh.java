package 牛客网.二期.yaoheng.class_01;

import java.util.Stack;

public class ExpressionCompute_yh {
    public static void main(String[] args) {
        String expression = "1*2/1+5-4/(3-1)";
        System.out.println(computeExpression(expression));
        expression = "1*2";
        System.out.println(computeExpression(expression));
        expression = "1*2*5/1";
        System.out.println(computeExpression(expression));
    }

    private static int computeExpression(String expression) {
        //存储数字
        Stack<Integer> stackNum = new Stack<>();
        //存储字符
        Stack<Character> stackChar = new Stack<>();
        //进行计算
        char[] eChar = expression.toCharArray();
        for (int i = 0; i < eChar.length; i++) {
            char ch = eChar[i];
            if (Character.isDigit(ch)) {//数字
                int num = 0;
                while (i < eChar.length && Character.isDigit(eChar[i])) {
                    num = num * 10 + (eChar[i] - '0');
                    i++;
                }
                stackNum.push(num);
                i--;
            } else if (ch == '(') { //左括号
                stackChar.push(ch);
            } else if (ch == ')') {//右括号
                //判定是否到左括号，否则运算
                while (!stackChar.isEmpty() && stackChar.peek() != '(') {
                    numE(stackNum, stackChar);
                }
                stackChar.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {//计算符
                //看运算级别，当前预算级别更加低，则运算前面的数据
                while (!stackChar.isEmpty() && checkC(stackChar.peek()) >= checkC(ch)) {
                    numE(stackNum, stackChar);
                }
                stackChar.push(ch);
            }
        }
        while (!stackChar.isEmpty()) {
            numE(stackNum, stackChar);
        }
        return stackNum.pop();

    }

    private static int checkC(char c) {
        //校验大小，当前的符号，栈中的符号
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    /**
     * 计算数据
     *
     * @param stackNum  数据
     * @param stackChar 计算符
     */
    private static void numE(Stack<Integer> stackNum, Stack<Character> stackChar) {
        //数一
        int num1 = stackNum.pop();
        //数二
        int num2 = stackNum.pop();
        //计算符
        char c = stackChar.pop();
        //开始运算，加减乘除
        int num = 0;
        switch (c) {
            case '+':
                num = num2 + num1;
                break;
            case '-':
                num = num2 - num1;
                break;
            case '*':
                num = num2 * num1;
                break;
            case '/':
                num = num2 / num1;
                break;
        }
        stackNum.push(num);
    }
}
