package performance;


import java.util.concurrent.atomic.AtomicLong;

public class IncrementDirect {
    static long foo = 0;
    static AtomicLong fooAtomic = new AtomicLong();
    static volatile long fooVolatile = 0;
    static Lock lock = new Lock();

    public static void main(String[] args) throws InterruptedException {
        long startTime, time;
        startTime = System.currentTimeMillis();
        for (long i = 0; i < 500000000L; i++) {
            foo++;
        }
        time = System.currentTimeMillis() - startTime;
        System.out.println("Single thread  " + Thread.currentThread().getName() + " execution time: " + time + "ms");

        startTime = System.currentTimeMillis();
        for (long i = 0; i < 500000000L; i++) {
            fooVolatile++;
        }
        time = System.currentTimeMillis() - startTime;
        System.out.println("Single thread (Volatile) " + Thread.currentThread().getName() + " execution time: " + time + "ms");


        startTime = System.currentTimeMillis();
        fooAtomic.set(0);
        for (long i = 0; i < 500000000L; i++) {
            fooAtomic.getAndIncrement();
        }
        time = System.currentTimeMillis() - startTime;
        System.out.println("Single thread (Atomic) " + Thread.currentThread().getName() + " execution time: " + time + "ms");

        startTime = System.currentTimeMillis();
        for (long i = 0; i < 500000000L; i++) {
            lock.lock();
            try {
                foo++;
            }finally {
                lock.unlock();
            }
        }
        time = System.currentTimeMillis() - startTime;
        System.out.println("Single thread (Lock) " + Thread.currentThread().getName() + " execution time: " + time + "ms");
        System.out.println("Two thread (Atomic) " + Thread.currentThread().getName() + " execution time: 48023ms");
        System.out.println("Two thread (Lock) " + Thread.currentThread().getName() + " execution time: 393039ms");


    }
}
