import java.util.Scanner;

public class DFS_gold {
    static Node[] nodeArr;
    static int sum = 0;
    static int[] value;
    static class Node{
        int left,right;
        Node(int left,int right){
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int t = scan.nextInt();
        value = new int[t + 1];
        nodeArr = new Node[t + 1];
        for(int i = 1; i <= t;i++){
            value[i] = scan.nextInt();
        }
        for(int i = 1; i <= t;i++){
            nodeArr[i] = new Node(scan.nextInt(),scan.nextInt());
        }
        DFS(1,0);
        System.out.print(sum);
        scan.close();
    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        value = new int[t];
//        nodeArr = new Node[t];
//        for(int i = 0; i < t;++i){
//            value[i] = scan.nextInt();
//        }
//        for(int i = 0; i < t;++i){
//            nodeArr[i] = new Node(scan.nextInt(),scan.nextInt());
//        }
//        DFS(0,0);
//        System.out.print(sum + value[0]);
//        scan.close();
//    }
    public static void DFS(int index,int godelNum){
        if(godelNum == 0) {
            sum += value[index];
        }
        if(nodeArr[index].left != -1) DFS(nodeArr[index].left - 1,godelNum + 1);
        if(nodeArr[index].right != -1) DFS(nodeArr[index].right - 1,godelNum - 1);
        /*
        * 题目为：
        * 给定一棵n 个点n-1条边的二叉树，编号为！！！！！！ 1,2,...,n！！！！！！！！，其中 1号点为根节点，其中第之个点的权重为 wi。
            请你计算出这棵树的 黄金指数 为 0 的点的权重之和。
            黄金指数:
            若一个点是它父节点的左儿子，则它的黄金指数为其父节点的黄金指数 +1。
            若一个点是它父节点的右儿子，则它的黄金指数为其父节点的黄金指数 -1。
            特别的，根节点的黄金指数为 0.
        * */
        //错误解法
//        if(nodeArr[index].left != -1) DFS(nodeArr[index].left,godelNum + 1);
//        if(nodeArr[index].right != -1) DFS(nodeArr[index].right,godelNum - 1);
    }
}
