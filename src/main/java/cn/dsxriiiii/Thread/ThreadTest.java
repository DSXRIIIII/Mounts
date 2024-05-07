package cn.dsxriiiii.Thread;

public class ThreadTest {
    public static void main(String[] args) {
        DSXRThread thread1 = new DSXRThread();
        thread1.start();

        DSXRRunnable threadOld = new DSXRRunnable();
        Thread thread2 = new Thread(threadOld);
        thread2.start();

        int n = 10;
        int numThread = 3;
        int numberPreThread = n / numThread;
        int start = 1;
        int end = numberPreThread;
        for (int i = 1; i < numberPreThread; i++) {
            if(i == numThread - 1){
                end += n % numThread;
            }
            NumberPrinter numberPrinter = new NumberPrinter(start,end);
            numberPrinter.start();
            start = end + 1;
            end += numberPreThread;
        }
    }
}
