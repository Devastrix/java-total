package training.concurrency.deadlock.locks;

public class ProducerThread extends Thread {

    private Buffer buffer;

    public ProducerThread(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        for (int i = 1; i < 25; i++) {
            buffer.writeData(i);
            System.out.println("----------> Producer produced " + i);
        }
    }
}
