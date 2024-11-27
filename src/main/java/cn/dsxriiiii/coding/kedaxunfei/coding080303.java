package cn.dsxriiiii.coding.kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/19 16:53
 * @Description:
 **/
public class coding080303 {
    // 定义一个常量N，用于表示数组的大小等相关用途，这里取100007
    static final int N = 100007;
    // 定义一个数组h，用于存储每个节点的邻接表表头索引，大小为N
    static int[] h = new int[N];
    // 定义一个数组e，用于存储边的终点节点编号，由于可能是无向图，边数最多可能是N * 2，所以大小为N * 2
    static int[] e = new int[N * 2];
    // 定义一个数组ne，用于存储邻接表中每条边的下一条边的索引，同样大小为N * 2，用于构建邻接表结构
    static int[] ne = new int[N * 2];
    // 定义一个数组w，用于存储每个节点的权重值，大小为N
    static int[] w = new int[N];
    // 定义一个数组ffmin，用于在深度优先搜索过程中记录以某个节点为根的子树中满足特定条件（w[u] <= w[j]）的最长路径长度，大小为N
    static int[] ffmin = new int[N];
    // 定义一个数组ffmax，用于在深度优先搜索过程中记录以某个节点为根的子树中满足特定条件（w[u] >= w[j]）的最长路径长度，大小为N
    static int[] ffmax = new int[N];
    // 用于记录边的索引，在构建邻接表时使用，初始化为0
    static int idx = 0;
    // 用于存储最终的结果，即满足条件的最长路径长度相关的计算结果，初始化为0
    static int res = 0;
    // 方法用于向邻接表中添加一条边，连接节点a和节点b
    static void add(int a, int b) {
        // 将边的终点节点b存储到e数组中，当前边的索引为idx
        e[idx] = b;
        // 将当前边的下一条边的索引设置为节点a的邻接表头索引h[a]所指向的边，即插入到邻接表头部
        ne[idx] = h[a];
        // 更新节点a的邻接表头索引为当前边的索引idx，完成边的添加
        h[a] = idx++;
    }
    // 深度优先搜索方法，用于计算以节点u为根的子树中满足w[u] <= w[j]条件的最长路径长度
    static int dfs1(int u, int fa) {
        // 如果ffmin[u]已经被计算过（不为0），直接返回其值，避免重复计算
        if (ffmin[u]!= 0) return ffmin[u];
        // 初始化ma为0，用于记录当前找到的满足条件的最长路径长度
        int ma = 0;
        // 初始化cma为0，用于辅助记录仅次于ma的满足条件的较长路径长度
        int cma = 0;
        // 遍历节点u的邻接表，通过h[u]获取邻接表头索引，ne[i]获取下一条边的索引，直到遍历完所有边（i == -1表示遍历结束）
        for (int i = h[u]; i!= -1; i = ne[i]) {
            // 获取当前边的终点节点j
            int j = e[i];
            // 如果终点节点j就是父节点fa，跳过本次循环，避免向上回溯到父节点
            if (j == fa) continue;
            // 递归调用dfs1方法，计算以节点j为根的子树中满足条件的最长路径长度tmax
            int tmax = dfs1(j, u);
            // 如果当前节点u的权重w[u]小于等于终点节点j的权重w[j]
            if (w[u] <= w[j]) {
                // 如果tmax大于等于ma，说明找到了更长的路径，更新cma和ma的值
                if (tmax >= ma) {
                    cma = ma;
                    ma = tmax;
                } else if (tmax > cma) {
                    // 如果tmax大于cma但小于ma，更新cma的值
                    cma = tmax;
                }
            }
        }

        // 如果ma和cma都大于0，说明找到了两条合适的路径，更新res为ma + cma + 1和当前res中的较大值
        if (ma > 0 && cma > 0) res = Math.max(res, ma + cma + 1);
        else
            // 如果只有ma大于0或者都不大于0，更新res为ma + 1和当前res中的较大值
            res = Math.max(res, ma + 1);
        // 将计算得到的以节点u为根的子树中满足条件的最长路径长度ma + 1赋值给ffmin[u]，以便后续可能的重复调用直接返回结果
        return ffmin[u] = ma + 1;
    }

    // 深度优先搜索方法，用于计算以节点u为根的子树中满足w[u] >= w[j]条件的最长路径长度
    static int dfs2(int u, int fa) {
        // 如果ffmax[u]已经被计算过（不为0），直接返回其值，避免重复计算
        if (ffmax[u]!= 0) return ffmax[u];
        // 初始化ma为0，用于记录当前找到的满足条件的最长路径长度
        int ma = 0;
        // 初始化cma为0，用于辅助记录仅次于ma的满足条件的较长路径长度
        int cma = 0;
        // 遍历节点u的邻接表，通过h[u]获取邻接表头索引，ne[i]获取下一条边的索引，直到遍历完所有边（i == -1表示遍历结束）
        for (int i = h[u]; i!= -1; i = ne[i]) {
            // 获取当前边的终点节点j
            int j = e[i];
            // 如果终点节点j就是父节点fa，跳过本次循环，避免向上回溯到父节点
            if (j == fa) continue;
            // 递归调用dfs2方法，计算以节点j为根的子树中满足条件的最长路径长度tmax
            int tmax = dfs2(j, u);
            // 如果当前节点u的权重w[u]大于等于终点节点j的权重w[j]
            if (w[u] >= w[j]) {
                // 如果tmax大于等于ma，说明找到了更长的路径，更新cma和ma的值
                if (tmax >= ma) {
                    cma = ma;
                    ma = tmax;
                } else if (tmax > cma) {
                    // 如果tmax大于cma但小于ma，更新cma的值
                    cma = tmax;
                }
            }
        }

        // 如果ma和cma都大于0，说明找到了两条合适的路径，更新res为ma + cma + 1和当前res中的较大值
        if (ma > 0 && cma > 0) res = Math.max(res, ma + cma + 1);
        else
            // 如果只有ma大于0或者都不大于0，更新res为ma + 1和当前res中的较大值
            res = Math.max(res, ma + 1);
        // 将计算得到的以节点u为根的子树中满足条件的最长路径长度ma + 1赋值给ffmax[u]，以便后续可能的重复调用直接返回结果
        return ffmax[u] = ma + 1;
    }

    public static void main(String[] args) {
        // 创建一个Scanner对象，用于从标准输入读取数据
        Scanner sc = new Scanner(System.in);
        // 从标准输入读取一个整数n，表示节点的数量
        int n = sc.nextInt();
        // 使用Arrays.fill方法将数组h的所有元素初始化为 -1，用于初始化邻接表头索引
        Arrays.fill(h, -1);
        // 循环读取每个节点的权重值，并存储到数组w中
        for (int i = 1; i <= n; i++) w[i] = sc.nextInt();
        // 循环读取边的信息，构建图的邻接表结构
        for (int i = 1; i < n; i++) {
            // 从标准输入读取一条边的一个端点a
            int a = sc.nextInt();
            // 从标准输入读取一条边的另一个端点b
            int b = sc.nextInt();
            // 调用add方法添加边(a, b)
            add(a, b);
            // 因为是无向图，所以还要添加边(b, a)
            add(b, a);
        }
        // 以节点1为根节点，调用dfs1方法进行深度优先搜索，计算满足w[u] <= w[j]条件的最长路径长度相关信息
        dfs1(1, -1);
        // 以节点1为根节点，调用dfs2方法进行深度优先搜索，计算满足w[u] >= w[j]条件的最长路径长度相关信息
        dfs2(1, -1);
        // 输出最终的结果res，即满足条件的最长路径长度相关的计算结果
        System.out.println(res);
        // 关闭Scanner对象，释放相关资源
        sc.close();
    }
}
