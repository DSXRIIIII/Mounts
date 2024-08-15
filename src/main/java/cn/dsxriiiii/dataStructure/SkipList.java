package cn.dsxriiiii.dataStructure;

import java.util.Random;

class Node {
    int value;
    Node[] next;

    public Node(int value, int level) {
        this.value = value;
        this.next = new Node[level + 1];
    }
}

public class SkipList {
    private static final int MAX_LEVEL = 16; // 最大层级
    private static final double PROBABILITY = 0.5; // 控制层级增长的概率

    private int level; // 当前跳表的最大层级
    private final Node header; // 虚拟头节点
    private final Random random; // 用于决定节点层级的随机数生成器

    public SkipList() {
        this.level = 0;
        this.header = new Node(Integer.MIN_VALUE, MAX_LEVEL);
        this.random = new Random();
    }

    // 随机生成节点层级
    private int randomLevel() {
        int level = 0;
        while (level < MAX_LEVEL && random.nextDouble() < PROBABILITY) {
            level++;
        }
        return level;
    }

    // 插入节点
    public void insert(int value) {
        int newLevel = randomLevel();

        // 如果新节点的层级大于当前跳表的最大层级，更新头节点的层级
        if (newLevel > level) {
            level = newLevel;
        }

        Node newNode = new Node(value, newLevel);

        Node current = header;

        // 从最高层开始找到合适的位置插入新节点
        for (int i = level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }

            if (i <= newLevel) {
                newNode.next[i] = current.next[i];
                current.next[i] = newNode;
            }
        }
    }

    // 查找节点
    public boolean search(int value) {
        Node current = header;

        // 从最高层开始查找
        for (int i = level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }

            if (current.next[i] != null && current.next[i].value == value) {
                return true;
            }
        }

        return false;
    }

    // 删除节点
    public void delete(int value) {
        Node current = header;

        // 从最高层开始找到要删除的节点
        for (int i = level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }

            if (current.next[i] != null && current.next[i].value == value) {
                current.next[i] = current.next[i].next[i];
            }
        }
    }

    // 打印跳表
    public void print() {
        for (int i = level; i >= 0; i--) {
            Node current = header;
            System.out.print("Level " + i + ": ");
            while (current.next[i] != null) {
                System.out.print(current.next[i].value + " ");
                current = current.next[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        skipList.insert(17);
        skipList.insert(26);
        skipList.insert(21);
        skipList.insert(25);

        skipList.print();

        System.out.println("Search 19: " + skipList.search(19));
        System.out.println("Search 20: " + skipList.search(20));

        skipList.delete(19);
        skipList.delete(25);

        skipList.print();
    }
}
