package cn.dsxriiiii.LeetCode.LC150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ProjectName: Mounts
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/3 16:41
 * @Email: lihh53453@hundsun.com
 */
public class LC71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> queue = new LinkedList<>();
        for(String str:split){
            if("..".equals(str)){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else if(!str.isEmpty() && !".".equals(str)){
                queue.addLast(str);
            }
            /*
            这样的写法会导"/.."的情况 不满足条件"..".equals(str) && !queue.isEmpty() 而走到!str.isEmpty() && !".".equals(str)
            此时满足条件 那么queue就会添加".."
             */
//            if("..".equals(str) && !queue.isEmpty()){
//                queue.pollLast();
//            }else if(!str.isEmpty() && !".".equals(str)){
//                queue.addLast(str);
//            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        if (queue.isEmpty()) {
            stringBuilder.append('/');
        } else {
            while (!queue.isEmpty()) {
                stringBuilder.append('/');
                stringBuilder.append(queue.pollFirst());
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LC71 lc71 = new LC71();
        lc71.simplifyPath("/..");
    }
}
