package training.concurrency.deadlock.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyDataStructure {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read1() {
        readWriteLock.readLock().lock();
        for (int i = 0; i < 10; i++) {
            System.out.println("Read1 ..." + i);
        }
        readWriteLock.readLock().unlock();
    }

    public void read2() {
        readWriteLock.readLock().lock();
        for (int i = 0; i < 10; i++) {
            System.out.println("Read2 ..." + i);
        }
        readWriteLock.readLock().unlock();
    }

    public void write1() {
        readWriteLock.writeLock().lock();
        for (int i = 0; i < 10; i++) {
            System.out.println("Write1 ..." + i);
        }
        readWriteLock.writeLock().unlock();
    }

    public void write2() {
        readWriteLock.writeLock().lock();
        for (int i = 0; i < 10; i++) {
            System.out.println("Write1 ..." + i);
        }
        readWriteLock.writeLock().unlock();
    }
}
