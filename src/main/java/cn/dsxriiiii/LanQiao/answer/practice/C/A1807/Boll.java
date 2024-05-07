package cn.dsxriiiii.LanQiao.answer.practice.C.A1807;


import java.util.Scanner;

/*
* Color the ball hdu 1556 http://acm.hdu.edu.cn/showproblem.php?pid=1556
* 问题描述：N个气球排成一排，从左到右依次编号为1, 2, 3 … N。每次给定2个整数L, R(L<= R)，lele从气球L开始到气球R依次给每个气球涂一次颜色。但是N次以后lele已经忘记了第I个气球已经涂过几次颜色了，你能帮他算出每个气球被涂过几次颜色吗？
* 输入：每个测试实例第一行为一个整数N，(N <= 100000)。接下来的N行，每行包括2个整数L, R(1 <= L<= R<= N)。当N = 0，输入结束。
* showBollColor()实现
* */

/*一维差分
 * 执行的输入输出结果：
 * 3
 * 1 1
 * 2 2
 * 3 3
 * 输出：1 1 1
 * 3
 * 1 1
 * 1 2
 * 1 3
 * 输出：3 2 1
 * 对于某些需要对区段进行处理的数组可以使用差分法
 * 首先需要定义一个差分数组，这个差分数组的长度最好是原来数组的长度+2，方便对差分数组进行处理
 * 而差分数组最核心的代码就是differBoll[a] +=1;  differBoll[b+1] -=1;
 * 这是对于差分数组的更新操作，位置坐标更新从 0 下标开始，直到 n，相当于0 到 n+1 都会更新
 * 而在更新结果数组的时候result[i] = result[i - 1] + differBoll[i];更新范围则是从 i=1 开始计算，坐标1需要从坐标0位置（数值为0）+ differBoll数组[0]进行更新*//*
 **/
public class Boll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            int n = scanner.nextInt();
            if(n == 0){
                break;
            }
            int[] differBoll = new int[n+2];
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                differBoll[a] +=1;
                differBoll[b+1] -=1;
            }
            int[] BollResult = calculateColors(differBoll);
            for(int i = 1; i < BollResult.length; i++){
            System.out.print(BollResult[i] + " ");
            n--;
            }
        }
    }
    public static int[] calculateColors(int[] differBoll){
        int N = differBoll.length - 2;
        int[] result = new int[N+1];
        for(int i = 1 ;i < result.length; i++){
            result[i] = result[i - 1] + differBoll[i];
        }
        return result;
    }
}
