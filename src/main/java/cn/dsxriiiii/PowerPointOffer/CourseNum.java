package cn.dsxriiiii.PowerPointOffer;
import java.util.*;

/*
*
*
* LCR 113. 课程表 II
* https://leetcode.cn/problems/QA2IGt/description/
*
* 思路：
* 1.创建坐标节点与列表绑定
* 2.链表添加节点，并且设置节点的入度
* 3.遍历找到入度，把入度为0的节点加入到队列之中
* 4.用order结果链表保存结果，再将入度为0的节点加入到队列queue之中
*
*
* order.stream().mapToInt(i->i).toArray()
* 将 List<Integer> 类型的链表 order 转换为一个 int 数组。
* 在这个特定的场景下，由于 order 中存储的是整数类型的课程顺序，
* 所以这种转换是很方便的。最终返回的是一个基本类型 int 数组，而不是 Integer 类型的数组。
* */
public class CourseNum {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }
        for(int[] temp : prerequisites){
            graph.get(temp[1]).add(temp[0]);
            inDegree[temp[0]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int course = queue.remove();
            order.add(course);
            for(int next : graph.get(course)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        return order.size() == numCourses ? order.stream().mapToInt(i->i).toArray() : new int[0];
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1}};
        CourseNum courseNum = new CourseNum();
        int[] Result = courseNum.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(Result));
    }
}
