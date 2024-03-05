package 牛客网.二期.yaoheng.class_06;

public class LongestSubarrayLessSumAwesomeSolution_yh {
    public static void main(String[] args) {
        int[] ins = new int[]{1, 2, 3, 4, 5, 6};
        int num = 9;
        int result = getLongestSubarray(ins, num);
        System.out.println(result);
    }

    private static int getLongestSubarray(int[] ins, int num) {
        int start = 0;
        int sum = 0;
        int length = 0;
        for (int end = 0; end < ins.length; end++) {
            sum += ins[end];
            while (sum >= num) {
                sum -= ins[start];
                start++;
            }

            length = Math.max(length, end - start + 1);
        }

        return length;
    }
}
