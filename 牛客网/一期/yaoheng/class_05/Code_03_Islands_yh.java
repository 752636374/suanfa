package 牛客网.一期.yaoheng.class_05;

public class Code_03_Islands_yh {

    public static void main(String[] args) {

        Integer[][] a1 = new Integer[][]{
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
        };
        System.out.println(isLand(a1));

        Integer[][] a2 = new Integer[][]{
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 1},
        };
        System.out.println(isLand(a2));
    }

    private static Integer isLand(Integer[][] a1) {
        int w = a1.length;
        int h = a1[0].length;
        int num = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (a1[i][j] == 1) {
                    num++;
                    mark(a1, i, j, w, h);
                }
            }
        }
        return num;
    }

    private static void mark(Integer[][] a1, int i, int j, int w, int h) {
        if (i < 0 || i >= w || j < 0 || j >= h || a1[i][j] != 1) {
            return;
        }
        a1[i][j]=2;
        mark(a1, i - 1, j, w, h);
        mark(a1, i + 1, j, w, h);
        mark(a1, i, j - 1, w, h);
        mark(a1, i, j + 1, w, h);
    }
}
