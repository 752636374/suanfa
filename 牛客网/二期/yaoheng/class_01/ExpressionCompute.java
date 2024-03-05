package 牛客网.二期.yaoheng.class_01;

import java.util.Stack;

/**
 * 实现逻辑： 该实现使用两个栈 numStack 和 opStack，通过遍历表达式并根据不同情况进行处理，计算出表达式的结果。其中，numStack 用于存储数字，opStack 用于存储运算符。
 *
 * 时间复杂度： 假设表达式的长度为 n，遍历表达式的时间复杂度为 O(n)。在遍历过程中，每个字符的处理时间复杂度为 O(1)。因此，总体时间复杂度为 O(n)。
 *
 * 空间复杂度： 使用了两个栈 numStack 和 opStack，它们的空间复杂度取决于表达式中数字和运算符的数量。最坏情况下，两个栈的空间复杂度都为 O(n)。因此，总体空间复杂度为 O(n)。
 *
 * 实现目的： 该实现的目的是计算一个算术表达式的结果。它支持括号、加法、减法、乘法和除法运算。
 *
 * 优势：
 *
 * 简单易懂：代码逻辑清晰，易于理解和实现。
 * 支持多种运算符：能够处理表达式中的加法、减法、乘法和除法运算。
 * 支持括号：能够处理表达式中的括号，保证了运算的正确顺序。
 * 劣势：
 *
 * 不支持负数和浮点数：该实现只支持处理整数运算，不能处理负数和浮点数。
 * 不支持其他函数和运算符：该实现只支持加法、减法、乘法和除法运算，不支持其他函数和运算符，如指数运算、取余等。
 * 不具备错误处理机制：如果表达式格式不正确，可能会导致运行时异常。
 */
public class ExpressionCompute {

    /**
     * 计算给定表达式的结果
     * @param expression 给定的表达式，只包含数字、加减乘除和括号
     * @return 表达式的计算结果
     */
    public static int computeExpression(String expression) {
        Stack<Integer> numStack = new Stack<>();//数字
        Stack<Character> opStack = new Stack<>();//符号

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                // 处理数字
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--;
                numStack.push(num);
            } else if (ch == '(') {
                // 处理左括号
                opStack.push(ch);
            } else if (ch == ')') {
                // 处理右括号
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    computeTop(numStack, opStack);
                }
                opStack.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // 处理运算符
                while (!opStack.isEmpty() && precedence(opStack.peek()) >= precedence(ch)) {
                    computeTop(numStack, opStack);
                }
                opStack.push(ch);
            }
        }

        while (!opStack.isEmpty()) {
            computeTop(numStack, opStack);
        }

        return numStack.pop();
    }

    // 计算栈顶的运算
    private static void computeTop(Stack<Integer> numStack, Stack<Character> opStack) {
        char op = opStack.pop();
        int num2 = numStack.pop();
        int num1 = numStack.pop();

        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        numStack.push(result);
    }

    // 返回运算符的优先级
    private static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Expression\t\tResult");
        String expression = "3+4*2/(1-5)";
        int result = computeExpression(expression);
        System.out.println( expression+"\t\t" + result);

    }
}
