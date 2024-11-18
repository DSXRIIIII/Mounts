package cn.dsxriiiii.ScenarioQuestion.ThreadPrintOE;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackageName: cn.dsxriiiii.ScenarioQuestion.ThreadPrintOE
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/14 11:37
 * @Description:
 **/
public class OneTwoThreePrint {
    private final int max;
    private int number;
    private OneTwoThreePrint(int max){
        this.max = max;
    }
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition condition_a = reentrantLock.newCondition();
    private final Condition condition_b = reentrantLock.newCondition();
    private final Condition condition_c = reentrantLock.newCondition();
    private void print_a(){
        print(()->{return number % 3 == 0});
    }
    private void print()
}
