package cn.dsxriiiii.PowerPointOffer;


import java.io.File;

/*
* 面试题116 朋友圈
* 本题也有bfs和dfs的解法
* 以下展示的是并查集的思路
* 函数FindFriendCircleNum返回最终结果
*   如果M[i][j] == 1 说明有朋友交际，如果他们的祖先还是一个，那么朋友圈的数量count就要减少（也就是说共享一个朋友圈）
*   虽然 fathers[i] = i 是初始化时的状态，但随着 Unit 方法的调用，fathers 数组中的值会发生变化。
*   表示节点所在的集合的根节点。这个变化是在 Unit 方法中通过 fathers[i] = fathers[j] 实现的
* 函数Unit合并父类
*   在Unit函数中如果使用findFather发现两个数的祖先节点不同，则将自己的祖宗节点指向另一个数
* 函数findFather用来查找父类
*   使用递归算法，直到某个节点只指向自己，那么这个节点就是找到的祖先节点
*
*
* */
public class FriendsCircle {
    public int FindFriendCircleNum(int[][] M){
        int count = M.length;
        int[] fathers = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            fathers[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1 && Unit(fathers,i,j)){
                    count--;
                }
            }
        }
        return count;
    }
    public Boolean Unit(int[] fathers,int i, int j){
        int father1 = findFather(fathers, i);
        int father2 = findFather(fathers, j);
        if(father1 != father2){
            fathers[father1] = fathers[father2];
            return true;
        }
        return false;
    }
    public int findFather(int[] fathers,int i){
        if(fathers[i] != i){
            fathers[i] =  findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    public static void main(String[] args) {
        FriendsCircle friendsCircle = new FriendsCircle();
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
        int Result = friendsCircle.FindFriendCircleNum(M);
        System.out.println(Result);
    }
}
