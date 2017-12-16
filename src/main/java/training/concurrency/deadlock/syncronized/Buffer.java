package training.concurrency.deadlock.syncronized;

public class Buffer {

    private int data;
    private volatile boolean hasConsumed = true;

    public synchronized void writeData(int data) {
        while (!hasConsumed) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Thread.sleep(100);//causes deadlock
        }
        this.data = data;
        this.hasConsumed = false;
        this.notify();
    }

    public synchronized int readData() {
        while (hasConsumed) {
            try {
                this.wait(); //wait & notify is the solution
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //            Thread.sleep(100);//causes deadlock
        }
        this.hasConsumed = true;
        this.notify();
        return this.data;
    }
}
