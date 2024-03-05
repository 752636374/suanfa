package 牛客网.二期.yaoheng.class_03;


import java.util.Random;

class SkipListNode_yh {
    Integer value;
    SkipListNode_yh[] next;

    public SkipListNode_yh(int value, int level) {
        this.value = value;
        next = new SkipListNode_yh[level];
    }
}

public class SkipList_yh {
    SkipListNode_yh head;
    int MAX_LEVEL = 16;
    double randomNum = 0.5;
    int size;
    int level;

    public SkipList_yh() {
        head = new SkipListNode_yh(Integer.MIN_VALUE, MAX_LEVEL);
        size = 0;
        level = 1;
    }


    private int getRandomLevel() {
        int levelC = 1;
        Random random = new Random();
        while (random.nextDouble() < randomNum && levelC < MAX_LEVEL) {
            levelC++;
        }
        return levelC;
    }

    private void add(int value) {
        //获取插入数据层级
        int currentLevel = getRandomLevel();

        //判定层高是否变化
        if (currentLevel > level) {
            currentLevel = level + 1;
        }

        //创建新的节点
        SkipListNode_yh newNode = new SkipListNode_yh(value, currentLevel);

        //获取需要修改的节点
        SkipListNode_yh[] update = new SkipListNode_yh[currentLevel];
        SkipListNode_yh current = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            update[i] = current;
        }

        //修改节点
        for (int i = 0; i < currentLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }

        if (level < currentLevel) {
            level = currentLevel;
        }

        size++;
    }


    public static void main(String[] args) {
        SkipList_yh skipList_yh = new SkipList_yh();
        skipList_yh.add(3);
        skipList_yh.add(1);
        skipList_yh.add(5);
        skipList_yh.add(2);
        skipList_yh.add(4);
        skipList_yh.print();
        System.out.println(skipList_yh.contains(2));
        skipList_yh.remove(2);
        skipList_yh.print();
        System.out.println(skipList_yh.contains(2));

    }

    private boolean contains(int value) {
        SkipListNode_yh current = head;
        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
        }

        return current.next[0] != null && current.next[0].value == value;
    }

    private void remove(int value) {
        //获取需要修改的节点
        SkipListNode_yh[] update = new SkipListNode_yh[level];
        SkipListNode_yh current = head;
        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            update[i] = current;
        }

        //更新数据
        if (current.next[0] != null && current.next[0].value == value) {
            SkipListNode_yh deleteValue = current.next[0];
            for (int i = 0; i < level; i++) {
                if (update[i].next[i] == deleteValue) {
                    update[i].next[i] = deleteValue.next[i];
                }
            }
            size--;
        }


    }

    private void print() {
        for (int i = level - 1; i >= 0; i--) {
            SkipListNode_yh current = head.next[i];
            System.out.print("第" + (i + 1) + "层：");
            while (current != null) {
                System.out.print(current.value + "  ");
                current = current.next[i];
            }
            System.out.println();
        }
    }


}
