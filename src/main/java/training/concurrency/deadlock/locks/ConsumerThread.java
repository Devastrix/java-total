package training.concurrency.deadlock.locks;

public class ConsumerThread extends Thread {

    private Buffer buffer;

    public ConsumerThread(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        for (int i = 1; i < 25; i++) {
            System.out.println("<----- Read data " + buffer.readData());
        }
    }
}
