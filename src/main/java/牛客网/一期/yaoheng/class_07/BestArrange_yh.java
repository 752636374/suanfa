package 牛客网.一期.yaoheng.class_07;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange_yh {

    public static void main(String[] args) {
        int[][] meetings = {{1, 2}, {1, 4}, {2, 3}, {4, 7}, {3, 5}};
        int maxMeetings = bestArray(meetings);
        System.out.println(maxMeetings);
    }

    private static int bestArray(int[][] meetings) {
        Arrays.sort(meetings, new MeetingComparator());
        int num = 1;
        int end = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            //对比当前的开始时间和上一个结束时间大小
            if (meetings[i][0] >= end) {
                num++;
                end = meetings[i][1];
            }
        }
        return num;
    }

    static class MeetingComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    }
}
