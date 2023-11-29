package cn.dsxriiiii.PowerPointOffer;

import java.util.*;
/*
* leetcode 339 除法求值
* https://leetcode.cn/problems/evaluate-division/description/
*
* */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if(!graph.containsKey(from) || !graph.containsKey(to)){
                results[i] = -1.0;
            }else{
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, from, to, visited);
            }
        }
        return results;
    }
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            graph.putIfAbsent(var1, new HashMap<String,Double>());
            graph.get(var1).put(var2, values[i]);
            graph.putIfAbsent(var2, new HashMap<String,Double>());
            graph.get(var2).put(var1, 1.0 / values[i]);
        }
        return graph;
    }
    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited){
        if (from.equals(to)){
            return 1.0;
        }
        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()){
            //entry获取邻居节点和对应的权重
            String next = entry.getKey();
            if (!visited.contains(next)){
                double nextValue = dfs(graph, next, to, visited);
                if (nextValue > 0){
                    return entry.getValue() * nextValue;
                }
            }
        }
        visited.remove(from);
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        List<List<String>> equations = new LinkedList<List<String>>() {{
            add(Arrays.asList("a", "b"));
            add(Arrays.asList("b", "c"));
        }};
        double[] values = {2.0,3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("e", "e")
        );

        double[] result = evaluateDivision.calcEquation(equations,values,queries);
        System.out.println(Arrays.toString(result));
    }
}

