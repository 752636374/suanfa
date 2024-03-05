package 牛客网.二期.yaoheng.class_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class BuildingOutline {
    static class Building {
        int left;  // the left position of the building
        int right; // the right position of the building
        int height; // the height of the building

        /**
         * Constructor for the Building class.
         *
         * @param left   the left position of the building
         * @param right  the right position of the building
         * @param height the height of the building
         */
        public Building(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    public List<int[]> getSkyline(Building[] buildings) {
        List<int[]> result = new ArrayList<>(); // 用于存储结果的列表

        // 将每个建筑物的左右边界和高度分别存储到两个列表中
        List<int[]> heights = new ArrayList<>(); // 用于存储建筑物边界和高度的列表
        for (Building building : buildings) { // 遍历建筑物列表
            heights.add(new int[]{building.left, -building.height}); // 左边界，高度取负值
            heights.add(new int[]{building.right, building.height}); // 右边界，高度为正值
        }

        // 按照横坐标排序
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // 按照横坐标升序排序
            } else {
                return a[1] - b[1]; // 如果横坐标相同，按照高度升序排序
            }
        });

        // 使用最大堆保存当前可见的建筑物高度
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 使用逆序排序的最大堆
        maxHeap.offer(0); // 将高度0加入堆中，作为初始高度
        int prevHeight = 0; // 保存前一个高度的变量

        for (int[] height : heights) { // 遍历排序后的边界和高度列表
            if (height[1] < 0) {  // 左边界，将高度加入最大堆
                maxHeap.offer(-height[1]); // 将高度取反后加入堆中
            } else {  // 右边界，将高度从最大堆中移除
                maxHeap.remove(height[1]); // 移除对应的高度
            }

            int currHeight = maxHeap.peek(); // 获取当前最大高度
            if (currHeight != prevHeight) {  // 当前最大高度与前一个高度不同，说明轮廓发生变化
                result.add(new int[]{height[0], currHeight}); // 将轮廓变化点的坐标和高度加入结果列表
                prevHeight = currHeight; // 更新前一个高度
            }
        }

        return result; // 返回结果列表
    }

    public static void main(String[] args) {
        // 创建一个Building对象数组，用于表示建筑物的信息
//        Building[] buildings = {
//                new Building(2, 9, 10),    // 建筑物1：起始位置2，结束位置9，高度10
//                new Building(3, 7, 15),    // 建筑物2：起始位置3，结束位置7，高度15
//                new Building(5, 12, 12),   // 建筑物3：起始位置5，结束位置12，高度12
//                new Building(15, 20, 10),  // 建筑物4：起始位置15，结束位置20，高度10
//                new Building(19, 24, 8)    // 建筑物5：起始位置19，结束位置24，高度8
//        };
        Building[] buildings = {
                new Building(2, 9, 10),    // 建筑物1：起始位置2，结束位置9，高度10
                new Building(3, 7, 6),    // 建筑物2：起始位置3，结束位置7，高度15

        };

        // 创建BuildingOutline对象
        BuildingOutline outline = new BuildingOutline();

        // 调用getSkyline方法获取建筑物的轮廓线
        List<int[]> skyline = outline.getSkyline(buildings);

        // 打印建筑物的轮廓线
        System.out.println("Building Outline:");
        for (int[] point : skyline) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}
