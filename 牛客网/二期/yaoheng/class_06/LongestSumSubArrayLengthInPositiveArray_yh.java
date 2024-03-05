package 牛客网.二期.yaoheng.class_06;

public class LongestSumSubArrayLengthInPositiveArray_yh {
    public static void main(String[] args) {
        int[] asr = new int[]{1, 2, 3, 4, 5,6};
        int num = 9;
        int length = getLongestNum(asr, num);
        System.out.println(length);
    }

    private static int getLongestNum(int[] asr, int num) {
        //初始化长度，
        int maxLen = 0;
        //当前和
        int currentNum = 0;
        //起始位置
        int start = 0;

        for (int end = 0; end < asr.length; end++) {
            currentNum += asr[end];
            while (currentNum > num) {
                currentNum -= asr[start];
                start++;
            }
            if(currentNum == num){
                maxLen = Math.max(maxLen,end-start+1);
            }
        }

        return maxLen;

    }
}
