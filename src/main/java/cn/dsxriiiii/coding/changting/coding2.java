package cn.dsxriiiii.coding.changting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.changting
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/11 19:39
 * @Description:
 **/
public class coding2 {
    // 定义内存块结构体
    static class MemoryBlock {
        int index;
        int availableMemory;
        int maxMemory;

        public MemoryBlock(int index, int availableMemory, int maxMemory) {
            this.index = index;
            this.availableMemory = availableMemory;
            this.maxMemory = maxMemory;
        }
    }

    // 最大堆，用于存储最大可用内存的内存块（用于WORST_FIT算法）
    private static PriorityQueue<MemoryBlock> maxHeap = new PriorityQueue<>((a, b) -> b.availableMemory - a.availableMemory);

    // 最小堆，用于存储最小可用内存的内存块（用于BEST_FIT算法）
    private static PriorityQueue<MemoryBlock> minHeap = new PriorityQueue<>((a, b) -> a.availableMemory - b.availableMemory);

    // 存储所有内存块的列表
    private static List<MemoryBlock> memoryBlocks = new ArrayList<>();

    // 记录已分配的内存总量
    private static int usedMemory = 0;

    public static void main(String[] args) {
        Scanner scanner = new java.util.Scanner(System.in);
        // 读取MEM_PAGE命令，初始化内存
        String firstLine = scanner.nextLine();
        String[] memPageParams = firstLine.split(" ");
        if (memPageParams[0].equals("MEM_PAGE") && memPageParams.length == 3) {
            int pageSize = Integer.parseInt(memPageParams[1]);
            int numPages = Integer.parseInt(memPageParams[2]);
            initializeMemory(pageSize, numPages);
        } else {
            System.out.println("Invalid MEM_PAGE command.");
            return;
        }

        // 循环处理其他命令
        while (scanner.hasNextLine()) {
            String commandLine = scanner.nextLine();
            String[] commandParams = commandLine.split(" ");
            if (commandParams.length == 2) {
                String command = commandParams[0];
                int size = Integer.parseInt(commandParams[1]);
                switch (command) {
                    case "ALLOCATE_FIRST_FIT":
                        allocateFirstFit(size);
                        break;
                    case "ALLOCATE_BEST_FIT":
                        allocateBestFit(size);
                        break;
                    case "ALLOCATE_WORST_FIT":
                        allocateWorstFit(size);
                        break;
                    case "FREE":
                        freeMemory(Integer.parseInt(commandParams[1]));
                        break;
                    case "ANALYZE":
                        analyzeMemory();
                        break;
                    default:
                        System.out.println("Invalid command.");
                        break;
                }
            }
        }

        scanner.close();
    }

    // 初始化内存
    private static void initializeMemory(int pageSize, int numPages) {
        for (int i = 0; i < numPages; i++) {
            MemoryBlock block = new MemoryBlock(i, pageSize, pageSize);
            memoryBlocks.add(block);
            maxHeap.add(block);
            minHeap.add(block);
        }
    }

    // ALLOCATE_FIRST_FIT算法实现
    private static void allocateFirstFit(int size) {
        for (MemoryBlock block : memoryBlocks) {
            if (block.availableMemory >= size) {
                block.availableMemory -= size;
                usedMemory += size;
                System.out.println("Memory Index is " + block.index);
                updateHeaps(block);
                return;
            }
        }
        System.out.println("Failed");
    }

    // ALLOCATE_BEST_FIT算法实现
    private static void allocateBestFit(int size) {
        MemoryBlock bestFitBlock = null;
        while (!minHeap.isEmpty()) {
            MemoryBlock block = minHeap.poll();
            if (block.availableMemory >= size) {
                bestFitBlock = block;
                break;
            }
        }
        if (bestFitBlock!= null) {
            bestFitBlock.availableMemory -= size;
            usedMemory += size;
            System.out.println("Memory Index is " + bestFitBlock.index);
            updateHeaps(bestFitBlock);
        } else {
            System.out.println("Failed");
        }
    }

    // ALLOCATE_WORST_FIT算法实现
    private static void allocateWorstFit(int size) {
        MemoryBlock worstFitBlock = null;
        while (!maxHeap.isEmpty()) {
            MemoryBlock block = maxHeap.poll();
            if (block.availableMemory >= size) {
                worstFitBlock = block;
                break;
            }
        }
        if (worstFitBlock!= null) {
            worstFitBlock.availableMemory -= size;
            usedMemory += size;
            System.out.println("Memory Index is " + worstFitBlock.index);
            updateHeaps(worstFitBlock);
        } else {
            System.out.println("Failed");
        }
    }

    // 释放内存
    private static void freeMemory(int index) {
        MemoryBlock blockToFree = null;
        for (MemoryBlock block : memoryBlocks) {
            if (block.index == index) {
                blockToFree = block;
                break;
            }
        }
        if (blockToFree!= null) {
            blockToFree.availableMemory += usedMemory;
            usedMemory -= usedMemory;
            updateHeaps(blockToFree);
        } else {
            System.out.println("Invalid index to free.");
        }
    }

    // 分析内存状态
    private static void analyzeMemory() {
        int totalMemory = 0;
        for (MemoryBlock block : memoryBlocks) {
            totalMemory += block.maxMemory;
        }
        int freeMemory = 0;
        for (MemoryBlock block : memoryBlocks) {
            freeMemory += block.availableMemory;
        }
        double fragmentation = ((double) (totalMemory - usedMemory)) / totalMemory * 100;
        System.out.println("Total Memory: " + totalMemory);
        System.out.println("Used Memory: " + usedMemory);
        System.out.println("Free Memory: " + freeMemory);
        System.out.println("Memory Fragmentation: " + String.format("%.2f", fragmentation) + "%");
    }

    // 更新最大堆和最小堆
    private static void updateHeaps(MemoryBlock block) {
        maxHeap.remove(block);
        minHeap.remove(block);
        maxHeap.add(block);
        minHeap.add(block);
    }
}
