package training.thread;

public class ChildThread extends Thread {

    @Override
    public void run() {
        System.out.println("I am a child");
    }
}
