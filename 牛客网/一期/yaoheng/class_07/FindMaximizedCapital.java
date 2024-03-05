package 牛客网.一期.yaoheng.class_07;

import java.util.PriorityQueue;

/**
 * 贪心算法是一种基于贪心策略的算法，它在每一步选择中都采取当前状态下最优的选择，以期望最终得到全局最优解。贪心算法的核心思想是通过局部最优解的选择来达到全局最优解，不考虑未来可能发生的情况。
 *
 * 贪心算法通常适用于满足贪心选择性质和最优子结构性质的问题。贪心选择性质指的是通过局部最优解选择来构建全局最优解；最优子结构性质指的是问题的最优解可以通过子问题的最优解来构建。
 *
 * 尽管贪心算法并不保证能够得到全局最优解，但它的优势在于其简单性和高效性。贪心算法通常具有较低的时间复杂度，并且可以在某些问题中提供较好的近似解。然而，对于涉及到全局最优解的问题，贪心算法可能会得到次优解或不正确的结果。因此，在使用贪心算法时需要仔细分析问题的特性和限制条件，以确保算法的正确性。
 *
 * 算法是一个贪心算法，用于在给定的初始资本和项目列表的情况下，选择最佳的项目以最大化资本的增长。
 */
public class FindMaximizedCapital {
    /**
     *
     * @param k 投资次数
     * @param initialCapital 初始资本
     * @param profits 每个项目利润
     * @param capital 每个项目成本
     * @return
     */
    public static int findMaximizedCapital(int k, int initialCapital, int[] profits, int[] capital) {
        int n = profits.length;

        // 创建小顶堆，按照项目的capital进行排序
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);

        // 创建大顶堆，按照项目的profit进行排序
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);

        // 将项目添加到小顶堆中
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new Project(capital[i], profits[i]));
        }

        // 选择项目
        for (int i = 0; i < k; i++) {
            // 将满足初始资本的项目添加到大顶堆中
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= initialCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll().profit);
            }

            // 如果大顶堆为空，表示没有可选项目
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // 选择当前最大利润的项目，更新初始资本
            initialCapital += maxProfitHeap.poll();
        }

        return initialCapital;
    }

    public static void main(String[] args) {
        int k = 2; // 设置最大投资项目数量为2
        int initialCapital = 0; // 设置初始资本为0
        int[] profits = {1, 2, 3}; // 每个项目的预期利润
        int[] capital = {0, 1, 1}; // 每个项目所需的资本

        int maxCapital = findMaximizedCapital(k, initialCapital, profits, capital); // 调用函数计算最大资本增长
        System.out.println("最大资本增长为：" + maxCapital); // 打印最大资本增长值
    }

    // 项目类
    static class Project {
        // 定义一个整型变量capital，表示项目的资本
        int capital;
        // 定义一个整型变量profit，表示项目的利润
        int profit;

        // 构造函数，用于初始化capital和profit
        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
}
