package training.concurrency.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutDownDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.execute(new RogueTask());
        executorService.execute(new WellManneredTask());
        System.out.println("About to shutdown...");
        executorService.shutdownNow();
    }
}

class WellManneredTask implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupted();
                System.out.println("Well Mannered was asked to shutdown... exiting");
                break;
            }
            System.out.println("Well Mannered Task Running..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class RogueTask implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("Rogue Task Running..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
