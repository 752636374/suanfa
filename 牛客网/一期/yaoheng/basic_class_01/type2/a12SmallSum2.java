package 牛客网.一期.yaoheng.basic_class_01.type2;

/**
 * 求左边小的数据的总和
 */
public class a12SmallSum2 extends AbstractSort2 {
    public static void main(String[] args) {
        new a12SmallSum2().run();
    }

    private void run() {
        boolean flag = true;
        int times = 0;
        while (flag && times++ < 100) {
            int[] as = random(40, 3);
            int[] as2 = copy(as);
            int valueDefault = getMinDefault(as);
            int value = getMin(as2, 0, as2.length - 1);
            if (value != valueDefault) {
                print("数组：", as);
                System.out.println("默认：" + valueDefault);
                System.out.println("我的：" + value);
                flag = false;
            }
        }
        if(flag){
            System.out.println("nice");
        }else {
            System.out.println("no no no");
        }
    }

    private int getMin(int[] as2, int left, int right) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        return getMin(as2, left, mid) + getMin(as2, mid + 1, right) + getValue(as2, left, mid, right);
    }

    /**
     * 保证两边内部有序
     * @param as2
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int getValue(int[] as2, int left, int mid, int right) {
        if (left == right) {
            return 0;
        }
        int num = 0;
        int l = left;
        int r = mid + 1;
        int[] values = new int[right - left + 1];
        int index = 0;
        while (l <= mid && r <= right) {
            if (as2[l] < as2[r]) {
                num += as2[l] * (right - r + 1);
                values[index++] = as2[l++];
            } else if (as2[l] == as2[r]) {
                values[index++] = as2[r++];
            } else {
                values[index++] = as2[r++];
            }
        }

        while (l <= mid) {
            values[index++] = as2[l++];
        }

        while (r <= right) {
            values[index] = as2[r++];
        }
        for (int i = 0; i < values.length; i++) {
            as2[left + i] = values[i];
        }
        return num;
    }

    private int getMinDefault(int[] as) {
        int num = 0;
        for (int i = 0; i < as.length; i++) {
            for (int j = 0; j < i; j++) {
                if (as[j] < as[i]) {
                    num += as[j];
                }
            }
        }
        return num;
    }

    @Override
    void mySort(int[] as) {

    }
}
