package 牛客网.二期.yaoheng.class_05;

import java.util.ArrayList;
import java.util.List;

public class MaxHappy_yh {
    static class Employee {
        Integer value;
        List<Employee> subordinates;

        public Employee(Integer value) {
            this.value = value;
            subordinates = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        Employee employee4 = new Employee(4);
        Employee employee5 = new Employee(5);

        employee1.subordinates.add(employee2);
        employee1.subordinates.add(employee3);

        employee2.subordinates.add(employee4);
        employee3.subordinates.add(employee5);

        System.out.println(maxHappy(employee1));
    }

    private static Integer maxHappy(Employee employee1) {
        if (employee1 == null) {
            return 0;
        }
        int[] r = dfs(employee1);
        return Math.max(r[0],r[1]);
    }

    private static int[] dfs(Employee employee) {
        if (employee == null) {
            return new int[]{0,0};
        }
        //初始化值，当当前节点，不含有当前节点
        int[] result = new int[]{0,0};
        int contain = employee.value;
        int containNo = 0;
        //查询子值
        for (Employee employee1 : employee.subordinates) {
            int[] ss = dfs(employee1);
            contain += ss[1];
            containNo = Integer.max(ss[0], ss[1]);
        }

        result[0] = contain;
        result[1] = containNo;
        return result;

    }
}
