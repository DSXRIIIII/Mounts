package cn.dsxriiiii.Thread;

public class NumberPrinter extends Thread{
    private int start;
    private int end;

    public NumberPrinter(int start,int end){
        this.start = start;
        this.end = end;
    }
    public void run(){
        for (int i = start; i < end; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + "数字" + i + "正在打印");
        }
    }
}
