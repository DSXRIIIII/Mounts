package cn.dsxriiiii.PowerPointOffer.BackTrack;
import java.util.LinkedList;
import java.util.List;

public class AllSubSetRepetitive {
    public static List<List<Integer>> subSet(int[] arr,int target){
        List<List<Integer>> res = new LinkedList<>();
        helper(arr,0,new LinkedList<>(),res,target);
        return res;
    }

    private static void helper(int[] arr, int index, LinkedList<Integer> path, List<List<Integer>> res,int target) {
        if(target == 0){
            res.add(new LinkedList<>(path));
            //res.add(path);
            //res.add(new LinkedList<>(path))： 在这种情况下，你每次都创建了 path 的新副本并添加到 res 中。
            // 这意味着 res 中的每个子集都是 path 的一个独立副本，后续对 path 的修改不会影响 res 中已经添加的子集。
            //res.add(path)： 在这种情况下，你直接将 path 添加到 res 中。这样的话，res 中的每个子集都引用了相同的 path 对象。
            // 这就意味着后续对 path 的修改会影响 res 中已经添加的子集，因为它们共享相同的对象引用。
        }else if(index < arr.length && target > 0){
            helper(arr,index,new LinkedList<>(),res,target);
            path.add(arr[index]);
            helper(arr,index,new LinkedList<>(),res,target - arr[index]);
            path.removeLast();
        }
    }
}
