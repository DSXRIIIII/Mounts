package cn.dsxriiiii.Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @PackageName: cn.dsxriiiii.Thread
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/19 14:10
 * @Description: CAS
 **/
public class CASExample {
    public static void main(String[] args) {
        //testCAS();
        testStampedCAS();
    }

    private static void testStampedCAS() {
        Integer initialValue = 5;
        Integer newValue = 10;
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(initialValue, 0);

        int[] stampHolder = new int[1];
        Integer reference = atomicStampedReference.get(stampHolder);
        System.out.println("初始值：" + reference + "，版本号：" + stampHolder[0]);

        boolean updated = atomicStampedReference.compareAndSet(reference, newValue, stampHolder[0], stampHolder[0] + 1);
        if (updated) {
            System.out.println("成功更新值为：" + atomicStampedReference.getReference() + "，版本号：" + atomicStampedReference.getStamp());
        }

        // 尝试模拟 ABA 问题，但由于版本号不同，不会成功
        updated = atomicStampedReference.compareAndSet(initialValue, newValue, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        if (updated) {
            System.out.println("再次成功更新值为：" + atomicStampedReference.getReference() + "，版本号：" + atomicStampedReference.getStamp());
        } else {
            System.out.println("再次更新失败，当前值为：" + atomicStampedReference.getReference() + "，版本号：" + atomicStampedReference.getStamp());
        }
    }

    private static void testCAS(){
        AtomicInteger atomicInteger = new AtomicInteger(0);

        // 模拟多个线程尝试进行 CAS 操作
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int expectedValue = atomicInteger.get();
                int newValue = expectedValue + 1;
                boolean updated = atomicInteger.compareAndSet(expectedValue, newValue);
                if (updated) {
                    System.out.println(Thread.currentThread().getName() + " 成功更新值为：" + newValue);
                } else {
                    System.out.println(Thread.currentThread().getName() + " 尝试更新失败，当前值为：" + atomicInteger.get());
                }
            },"线程"+i).start();
        }
    }
}
