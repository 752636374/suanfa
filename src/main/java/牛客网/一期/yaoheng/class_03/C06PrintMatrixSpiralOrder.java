package 牛客网.一期.yaoheng.class_03;

public class C06PrintMatrixSpiralOrder {

    public static void main(String[] args) {
        int[][] as = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrixSpiralOrder(as);
    }

    private static void matrixSpiralOrder(int[][] as) {
        if (as == null) {
            return;
        }
        int aMin = 0;
        int aMax = as.length - 1;
        int bMin = 0;
        int bMax = as[0].length - 1;
        while (aMin <= aMax) {
            matrix(as, aMin++, aMax--, bMin++, bMax--);
        }
    }

    private static void matrix(int[][] as, int aMin, int aMax, int bMin, int bMax) {
        if(aMax ==aMin){
            System.out.print(as[aMax][bMax]);
        }
        int length = aMax - aMin;
        int x = aMin;
        int y = bMin;
        for (int i = 0; i < length; i++) {
            System.out.print(as[bMin][aMin + i] + "  ");
        }
        for (int i = 0; i < length; i++) {
            System.out.print(as[bMin + i][aMax] + "  ");
        }
        for (int i = 0; i < length; i++) {
            System.out.print(as[bMax][aMax - i] + "  ");
        }
        for (int i = 0; i < length; i++) {
            System.out.print(as[bMax - i][aMin] + "  ");
        }
    }
}
