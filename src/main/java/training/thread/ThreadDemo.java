package training.thread;

public class ThreadDemo {


    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread);
        thread.setName("manipulated main");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(thread);

        ChildThread childThread = new ChildThread();
        childThread.start();
    }
}
