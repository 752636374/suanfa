package 牛客网.一期.yaoheng.class_03;

public class C05RotateMatrix {
    public static void main(String[] args) {
        int[][] as = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printArray(as);
        matrix(as);
        System.out.println("==========================");
        printArray(as);
    }

    private static void matrix(int[][] as) {
        int a = 0;
        int b = 0;
        int c = as.length - 1;
        int d = as[0].length - 1;
        while (a < c) {
            moveData(as, a++, b++, c--, d--);
        }
    }

    private static void moveData(int[][] as, int aMin, int bMin, int aMax, int bMax) {
        int num = aMax - aMin;
        int swap;
        for (int i = 0; i < num; i++) {
            swap = as[aMin][bMin + i];
            as[aMin][bMin + i] = as[aMin + i][bMax];
            as[aMin + i][bMax] = as[aMax][bMax - i];
            as[aMax][bMax - i] = as[aMax - i][bMin];
            as[aMax - i][bMin] = swap;
        }
    }

    private static void printArray(int[][] as) {
        if (as.length == 0) {
            return;
        }
        for (int i = 0; i < as.length; i++) {
            for (int j = 0; j < as[i].length; j++) {
                System.out.print(as[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
