package 牛客网.二期.yaoheng.class_07;

import 牛客网.二期.yaoheng.TimeNumUtils;

public class MinPathSum2_yh {
    public static void main(String[] args) {
        int[][] nums = { {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int paht = minPathHelp(nums);
        System.out.println(paht);
        TimeNumUtils.end();
    }

    private static int minPathHelp(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        return minPath(nums, row - 1, col - 1);
    }

    private static int minPath(int[][] nums, int row, int col) {
        TimeNumUtils.inc();
        if (row == 0 && col == 0) {
            return nums[row][col];
        }

        if (row == 0) {
            return minPath(nums,row,col-1)+nums[row][col];
        }

        if (col == 0) {
            return minPath(nums,row-1,col)+nums[row][col];
        }
        return Math.min(minPath(nums, row - 1, col), minPath(nums, row, col - 1))+nums[row][col];
    }
}
