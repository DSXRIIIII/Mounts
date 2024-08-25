package cn.dsxriiiii.ScenarioQuestion.Josephus;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.Josephus
 * @Date 2024/8/21 14:29
 * @Description: 约瑟夫环
 * 公公又式式
 */
public class JosephusRing {
    public int f(int n,int k){
        if(n == 1){
            return 1;
        }
        return f(f(n - 1,k)+k-1,k-1)%(n-1);
    }
}
