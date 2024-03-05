package 牛客网.二期.yaoheng.class_07;

public class MinPathSum_yh {
    public static void main(String[] args) {
        int[][] ins = {  {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int length = minPaht(ins);
        System.out.println(length);
    }

    private static int minPaht(int[][] ins) {
        //获取行列
        int row = ins.length;
        int col = ins[0].length;

        //初始缓存矩阵
        int[][] nums = new int[row][col];
        nums[0][0] = ins[0][0];
        for (int i = 1; i < row; i++) {
            nums[i][0] = nums[i - 1][0] + ins[i][0];
        }
        for (int j = 1; j < col; j++) {
            nums[0][j] = nums[0][j - 1] + ins[0][j];
        }

        //设置数据
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                nums[i][j]= Math.min(nums[i-1][j],nums[i][j-1])+ins[i][j];
            }
        }

        return nums[row - 1][col - 1];
    }
}
