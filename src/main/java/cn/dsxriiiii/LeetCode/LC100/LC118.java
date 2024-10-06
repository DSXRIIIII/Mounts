package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 17:41
 * @Description:
 **/
public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                if(i == j || j == 0){
                    temp.add(1);
                }else{
                    temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
