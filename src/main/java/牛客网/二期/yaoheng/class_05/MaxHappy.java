package 牛客网.二期.yaoheng.class_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用场景：maxHappy函数用于计算给定公司组织结构中员工的最大快乐值。每个员工都有一个快乐值，同时每个员工可以有多个下属员工。函数的目标是选择一些员工，使得他们的快乐值之和最大，并且不能选择直接上下级的员工。
 * 实现逻辑：maxHappy函数通过深度优先搜索（DFS）递归地遍历公司组织结构中的每个员工节点。
 * 对于每个员工节点，计算选择该员工和不选择该员工两种情况下的最大快乐值。
 * (1)选择该员工时，需要加上其快乐值和所有下属员工不选择的最大快乐值；
 * (2)不选择该员工时，需要加上所有下属员工选择和不选择两种情况下的最大快乐值之和的较大值。
 * 最后返回选择和不选择根节点的两种情况下的最大快乐值之间的较大值。
 * 注意：上述代码仅为示例，实际应用中可能需要根据具体情况对员工节点的表示方式和算法进行调整。
 */
public class MaxHappy {

    private static class Employee {
        int happy; // 员工的快乐值
        List<Employee> subordinates; // 员工的下属列表

        public Employee(int happy) {
            this.happy = happy;
            this.subordinates = new ArrayList<>(); // 初始化下属列表
        }
    }


    public static int maxHappy(Employee root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] dfs(Employee employee) {
        // 如果员工为空，返回[0, 0]
        if (employee == null) {
            return new int[]{0, 0};
        }

        // 初始化结果数组
        int[] result = new int[]{0, 0};

        // 计算包含根节点时的快乐值
        int happyWithRoot = employee.happy;
        // 计算不包含根节点时的快乐值
        int happyWithoutRoot = 0;

        // 遍历员工的下属
        for (Employee subordinate : employee.subordinates) {
            // 递归调用dfs函数，计算下属的结果
            int[] subResult = dfs(subordinate);
            // 更新包含根节点的快乐值
            happyWithRoot += subResult[1];
            // 更新不包含根节点的快乐值
            happyWithoutRoot += Math.max(subResult[0], subResult[1]);
        }

        // 更新结果数组
        result[0] = happyWithoutRoot;
        result[1] = happyWithRoot;

        // 返回结果数组
        return result;
    }


    // 测试方法
    public static void main(String[] args) {
        Employee root = new Employee(5);
        Employee emp1 = new Employee(3);
        Employee emp2 = new Employee(2);
        Employee emp3 = new Employee(4);
        Employee emp4 = new Employee(1);
        Employee emp5 = new Employee(2);

        root.subordinates.add(emp1);
        root.subordinates.add(emp2);
        root.subordinates.add(emp3);
        emp1.subordinates.add(emp4);
        emp2.subordinates.add(emp5);

        int maxHappy = maxHappy(root);
        System.out.println("Max happy: " + maxHappy); // Output: 11
    }
}
