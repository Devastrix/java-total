package training.concurrency.deadlock.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private int data;
    private boolean hasConsumed = true;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void writeData(int data) {
        try {
            lock.lock();
            while (!hasConsumed) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.data = data;
            this.hasConsumed = false;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int readData() {
        lock.lock();
        try {
            while (hasConsumed) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.hasConsumed = true;
            notFull.signal();
            return this.data;
        }finally {
            lock.unlock();
        }
    }
}
