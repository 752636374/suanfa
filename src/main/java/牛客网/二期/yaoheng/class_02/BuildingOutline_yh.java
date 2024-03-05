package 牛客网.二期.yaoheng.class_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 计算建筑的轮廓线
 */
public class BuildingOutline_yh {
    static class Building {
        Integer left;
        Integer right;
        Integer height;

        public Building(Integer left, Integer right, Integer height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        //创建楼层
        Building[] buildings = {
                new Building(2, 9, 10),
                new Building(3, 4, 7),
        };
        //获取楼的轮廓
        BuildingOutline_yh buildingOutlineYh = new BuildingOutline_yh();
        List<int[]> lines = buildingOutlineYh.getLine(buildings);
        for (int[] in : lines) {
            System.out.println(in[0] + "\t" + in[1]);
        }
    }

    private List<int[]> getLine(Building[] buildings) {
        //排序


        //创建返回数据
        List<int[]> result = new ArrayList<>();

        //存放每个建筑高度，区分开始结束
        List<int[]> heights = new ArrayList<>();
        for (Building building : buildings) {
            heights.add(new int[]{building.left, -building.height});
            heights.add(new int[]{building.right, building.height});
        }
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        //存放高度
        PriorityQueue<Integer> stack = new PriorityQueue<>(Collections.reverseOrder());
        stack.offer(0);//设置初始高度
        int preHeight = 0;//当前的建筑高度
        for (int[] height : heights) {
            //判断是否是入口
            if (height[1] < 0) {
                stack.offer(-height[1]);
            } else {
                stack.remove(height[1]);
            }
            int currentHeight = stack.peek();
            if (currentHeight != preHeight) {
                result.add(new int[]{height[0], currentHeight});
                preHeight = currentHeight;
            }
        }

        return result;
    }
}
