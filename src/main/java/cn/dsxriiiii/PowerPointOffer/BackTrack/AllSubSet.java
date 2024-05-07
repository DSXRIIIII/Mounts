package cn.dsxriiiii.PowerPointOffer.BackTrack;

import java.util.LinkedList;
import java.util.List;

//求所有的子集
public class AllSubSet {
    public List<List<Integer>> subSet(int[] arr){
        List<List<Integer>> res = new LinkedList<>();
        helper(arr,0,new LinkedList<>(),res);
        return res;
    }
    public static void helper(int[] arr,int index,LinkedList<Integer> path,List<List<Integer>> res){
        if(index == arr.length){
            res.add(new LinkedList<>(path));
        }else if(index < arr.length){
            helper(arr,index+1,path,res);
            path.add(arr[index]);
            helper(arr,index+1,path,res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        AllSubSet allSubSet = new AllSubSet();
        List<List<Integer>> result = allSubSet.subSet(arr);
        System.out.println(result.toString());
    }
}
