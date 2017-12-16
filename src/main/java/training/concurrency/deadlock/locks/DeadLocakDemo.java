package training.concurrency.deadlock.locks;

public class DeadLocakDemo {


    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        ProducerThread producerThread = new ProducerThread(buffer);
        ConsumerThread consumerThread = new ConsumerThread(buffer);
        System.out.println("Starting both the tasks...");
        producerThread.start();
        consumerThread.start();
    }
}
