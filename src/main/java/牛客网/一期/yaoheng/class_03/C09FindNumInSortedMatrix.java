package 牛客网.一期.yaoheng.class_03;

public class C09FindNumInSortedMatrix {
    public static void main(String[] args) {
        int[][] as = new int[][]{{0, 1, 2, 3, 4, 5, 6},// 0
                {10, 12, 13, 15, 16, 17, 18},// 1
                {23, 24, 25, 26, 27, 28, 29},// 2
                {44, 45, 46, 47, 48, 49, 50},// 3
                {65, 66, 67, 68, 69, 70, 71},// 4
                {96, 97, 98, 99, 100, 111, 122},// 5
                {166, 176, 186, 187, 190, 195, 200},// 6
                {233, 243, 321, 341, 356, 370, 380} // 7
        };
        int k = 233;
        System.out.println(inContains(as, k));
    }

    private static boolean inContains(int[][] as, int k) {
        int row = 0;
        int col = as[0].length - 1;
        while (row < as.length && col >= 0) {
            if (as[row][col] == k) {
                return true;
            } else if (as[row][col] > k) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
