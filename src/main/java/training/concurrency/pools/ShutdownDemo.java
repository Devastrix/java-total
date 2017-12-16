package training.concurrency.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownDemo {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(new WellManneredTask());
		System.out.println("About to shutdown");
		pool.shutdownNow();

	}

}

class WellManneredTask implements Runnable{
	@Override
	public void run() {
		while(true){
			System.out.println("well mannered task running");
			if(Thread.currentThread().isInterrupted()){
				Thread.currentThread().interrupted();
				System.out.println("Bye bye cruel world...");
				break;
			}
		}
		
	}
}




class RogueTask implements Runnable{
	@Override
	public void run() {
		while(true){
			System.out.println("rogue task running");
			
		}
		
	}
}













