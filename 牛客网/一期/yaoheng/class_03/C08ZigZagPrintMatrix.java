package 牛客网.一期.yaoheng.class_03;

public class C08ZigZagPrintMatrix {


    public static void main(String[] args) {
        int[][] as = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15,16}, {17,18,19,20}};
        zigZag(as);
    }

    private static void zigZag(int[][] as) {
        int aMin = 0;
        int aMax = as.length - 1;
        int bMin = 0;
        int bMax = as[0].length - 1;
        for (int i = 0; i < aMax; i++) {

        }
        int a = aMin;
        int b = bMin;
        int ax = aMin;
        int bx = bMin;
        boolean flag = true;

        while (!(a == aMax && b == bMax && ax == aMax && bx == bMax)) {
            if (flag) {
                for (int x = a, y = bx; x >= ax && y <= b; x--, y++) {
                    System.out.print(as[x][y] + "\t");
                }
            } else {
                for (int x = ax, y = b; x <= a && y >= bx; x++, y--) {
                    System.out.print(as[x][y] + "\t");
                }
            }

            if (a < aMax) {
                a++;
            } else {
                bx++;
            }

            if (b < bMax) {
                b++;
            } else {
                ax++;
            }

            flag = !flag;
        }
        System.out.println(as[aMax][bMax]);

        System.out.println();
    }
}
