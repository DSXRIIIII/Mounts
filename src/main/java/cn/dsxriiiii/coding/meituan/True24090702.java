package cn.dsxriiiii.coding.meituan;

import cn.hutool.core.lang.tree.Tree;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.meituan
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/07 10:33
 * @Description: main2
 **/
public class True24090702 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, List<Integer>> inner = new HashMap<>();
        Map<Integer, List<Integer>> out = new HashMap<>();
        Map<Integer, Integer> node = new HashMap<>();
        inner.put(1,new ArrayList<>());
        out.put(2,new ArrayList<>());
        while(n-->0){
            int x = scanner.nextInt() - 1;
            for(int i = 0;i < x;i++){
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                node.put(num1,node.getOrDefault(num1,0) + 1);
                out.getOrDefault(node.get(num1),new ArrayList<>()).add(num1);
                inner.getOrDefault(node.getOrDefault(num2,0) + 1,new ArrayList<>()).add(num2);
            }
            for(List<Integer> value : inner.values()){
                for(List<Integer> value2 : out.values()){
                    Set<Integer> set = new HashSet<>(value);
                }
            }
        }
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
