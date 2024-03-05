package 牛客网.一期.yaoheng.class_07;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    public static int bestArrange(int[][] meetings) {
        // 使用自定义的Comparator对会议进行排序，按结束时间升序排列
        Arrays.sort(meetings, new MeetingComparator());

        int count = 1; // 记录最多能安排的会议数量
        int endTime = meetings[0][1]; // 记录当前会议的结束时间

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] >= endTime) {
                // 如果下一个会议的开始时间晚于等于当前会议的结束时间，可以安排该会议
                count++;
                endTime = meetings[i][1];
            }
        }

        return count;
    }

    // 自定义的Comparator，用于比较会议的结束时间
    static class MeetingComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] meeting1, int[] meeting2) {
            return meeting1[1] - meeting2[1]; // 按结束时间升序排列
        }
    }

    public static void main(String[] args) {
        int[][] meetings = {{1, 3}, {2, 4}, {3, 5}, {4, 6},{2,3},{1,2}};
        int maxMeetings = bestArrange(meetings);
        System.out.println("Maximum number of meetings that can be arranged: " + maxMeetings); // 输出 2
    }
}
