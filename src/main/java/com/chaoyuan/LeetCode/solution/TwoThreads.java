package com.chaoyuan.LeetCode.solution;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TwoThreads.
 *
 * @author: chaoyuan
 * @since: 2025/11/4 17:29
 * @description:
 */
public class TwoThreads {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final int max = 100;


    public static void main(String[] args) {
        new Thread(new MyThread(conditionA, conditionB, 1)).start();
        new Thread(new MyThread(conditionB, conditionA, 2)).start();
    }

    private static class MyThread implements Runnable {
        private final Condition conditionA;
        private final Condition conditionB;
        private int count;

        public MyThread(Condition conditionA, Condition conditionB, int count) {
            this.conditionA = conditionA;
            this.conditionB = conditionB;
            this.count = count;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (; count <= max; count += 2) {
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    conditionB.signal();
                    if (count < max - 1)
                        conditionA.awaitUninterruptibly();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
