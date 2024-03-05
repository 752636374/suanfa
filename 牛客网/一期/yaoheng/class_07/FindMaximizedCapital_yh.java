package 牛客网.一期.yaoheng.class_07;

import java.util.PriorityQueue;

public class FindMaximizedCapital_yh {


    public static void main(String[] args) {
        //设置投资次数
        int cunt = 2;

        //设置初始资本
        int initialCapital = 0;

        //设置利润
        int[] profits = {1,2,3};

        //设置成本
        int[] capital = {0,1,1};

        int maxCapital = findMaxCapital(cunt,initialCapital,capital,profits);

        System.out.println(maxCapital);

    }

    /**
     * 贪心算法获取最大的利润
     * @param cunt 投资次数
     * @param initialCapital 初始本金
     * @param capital 成本
     * @param profits 利润
     * @return
     */
    private static int findMaxCapital(int cunt, int initialCapital, int[] capital, int[] profits) {

        //利润项目数
        int num = capital.length;
        //利润的大顶堆
        PriorityQueue<Integer> maxProfitQueue = new PriorityQueue<>((a,b)->a-b);
        //成本的小顶堆
        PriorityQueue<Project> minCapitalQueue = new PriorityQueue<>((a,b)->a.capital-b.capital);

        for(int i =0;i<num;i++){
            minCapitalQueue.add(new Project(capital[i],profits[i]));
        }

        for(int i =0 ;i<num;i++){
            //获取成本最小的项目开始
            if(cunt>0 && minCapitalQueue.peek().capital<=initialCapital){
                maxProfitQueue.add( minCapitalQueue.poll().profit);
                cunt --;
            }
            //重新计算本金
            if(maxProfitQueue.isEmpty()){
                continue;
            }
            initialCapital += maxProfitQueue.poll();
        }

       return initialCapital;
    }

    //投资，利润类
    static class Project {
        int capital;
        int profit;
        public Project(int capital,int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
}
