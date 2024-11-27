package cn.dsxriiiii.ScenarioQuestion.ThreadPrintOE;

/**
 * @PackageName: cn.dsxriiiii.ScenarioQuestion.ThreadPrintOE
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/14 12:04
 * @Description:
 **/
public class PracticeOddEven {
    private final int max;
    private final Object object = new Object();
    private int index = 0;
    private PracticeOddEven(int max){
        this.max = max;
    }
    private void printOdd(){
        print("Odd");
    }
    private void printEven(){
        print("Even");
    }
    private void print(String s) {
        for (int i = 0; i < max; i+=2) {
            synchronized (object) {
                while (index % 2 == 0 == s.equals("Odd")){
                    try{
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + index++);
                object.notify();
            }
        }
    }

    public static void main(String[] args) {
        PracticeOddEven practiceOddEven = new PracticeOddEven(100);
        Thread A = new Thread(practiceOddEven::printEven,"A");
        Thread B = new Thread(practiceOddEven::printOdd,"B");
        A.start();
        B.start();
    }
}
