package 牛客网.二期.yaoheng.class_06;

public class CardsInLine2_yh {
    public static void main(String[] args) {
        int[] ins = new int[]{1, 2, 3, 4, 5};
        System.out.println(getCardSmaxHlep(ins));
    }

    private static int getCardSmaxHlep(int[] ins) {
      return   getMax(ins,0,ins.length-1);
    }

    private static int getMax(int[] ins, int start, int end) {
        if(start  == end){
            return ins[start];
        }
        int left = ins[start]-getMax(ins,start+1,end);
        int right = ins[end]-getMax(ins,start,end-1);
        return Math.max(left,right);
    }
}
