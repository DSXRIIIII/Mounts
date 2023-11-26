package cn.dsxriiiii.PowerPointOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class AllPathsSearch {
    public static void main(String[] args) {
        //Test
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(list.size() - 1);
        System.out.println(Arrays.toString(list.toArray()));


        int[][] graph1 = new int[][]{{1, 2}, {3}, {3}, {}};
        AllPathsSearch allPathsSearch = new AllPathsSearch();
        List<List<Integer>> finalResult = allPathsSearch.allPathsSourceTarget(graph1);
        System.out.println(Arrays.deepToString(graph1));
        System.out.println(Arrays.toString(finalResult.toArray()));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfsTest(0, graph, result, path);
        return result;
    }
    private void dfs(int temp, int[][] graph, List<List<Integer>> result, List<Integer> path){
        path.add(temp);
        if(temp == graph.length - 1){
            result.add(new LinkedList<>(path));//新增new LinkedList<>(path)
        }else{
            for(int next:graph[temp]){
                dfs(next, graph, result, path);
            }
        }
        path.remove(path.size() - 1);
    }
    private void dfsTest(int temp, int[][] graph, List<List<Integer>> result, List<Integer> path){
        System.out.println("Adding " + temp + " to path: " + Arrays.toString(path.toArray()));
        path.add(temp);
        if(temp == graph.length - 1){
            result.add(new LinkedList<>(path));
            System.out.println("Reached target, path added to result: " + Arrays.toString(path.toArray()));
        } else {
            for(int next : graph[temp]){
                dfsTest(next, graph, result, path);
            }
        }
        System.out.println("Removing " + path.get(path.size() - 1) + " from path: " + Arrays.toString(path.toArray()));
        path.remove(path.size() - 1);
        /*
        测试结果Adding 0 to path: []
        Adding 1 to path: [0]
        Adding 3 to path: [0, 1]
        Reached target, path added to result: [0, 1, 3]
        Removing 3 from path: [0, 1, 3]
        Removing 1 from path: [0, 1]
        Adding 2 to path: [0]
        Adding 3 to path: [0, 2]
        Reached target, path added to result: [0, 2, 3]
        Removing 3 from path: [0, 2, 3]
        Removing 2 from path: [0, 2]
        Removing 0 from path: [0]
        [[1, 2], [3], [3], []]
        [[0, 1, 3], [0, 2, 3]]
        */
    }

}
