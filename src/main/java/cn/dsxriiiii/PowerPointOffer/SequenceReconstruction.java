package cn.dsxriiiii.PowerPointOffer;

import jdk.nashorn.internal.IntDeque;

import java.rmi.UnexpectedException;
import java.util.*;

/*
* LCR115 序列重建
* https://leetcode.cn/problems/ur2n8P/description/
* */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> InDegree = new HashMap<>();
        for (int[] seq : sequences) {
            for (int num : seq) {
                if (num < 1 || num > nums.length) {
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<>());
                InDegree.putIfAbsent(num, 0);
            }
            for (int i = 0; i < seq.length - 1; i++) {
                int num1 = seq[i];
                int num2 = seq[i + 1];
                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    InDegree.put(num2, InDegree.get(num2) + 1);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int next : graph.keySet()) {
            if (InDegree.get(next) == 0) {
                queue.add(next);
            }
        }
        List<Integer> build = new LinkedList<>();
        while (queue.size() == 1) {
            int temp = queue.remove();
            build.add(temp);
            for (int next : graph.get(temp)) {
                InDegree.put(next, InDegree.get(next) - 1);
                if (InDegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        int[] Result = new int[nums.length];
        System.out.println(build);
        System.out.println(build.stream());
        System.out.println(build.stream().mapToInt(i->i));
        System.out.println(build.stream().mapToInt(i->i).toArray());
        System.out.println(nums);
        Result =build.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(build.toArray()));
        return Arrays.equals(nums,Result);
        // 在Java中，List类中的toArray()方法返回一个Object[]数组。如果你的List包含基本数据类型（如int）
        // 那么toArray()返回的数组将是Object[]，而不是原始数据类型数组。为了将List中的元素转换为原始数据类型的数组（例如int[]）
        // 你需要使用stream和mapToInt等方法。
    }
    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        int[] nums = {1,2,3};
        int[][] sequences = {{1,2},{1,3}};
        boolean result = sequenceReconstruction.sequenceReconstruction(nums,sequences);
        System.out.println(result);
    }
}
