package training.concurrency.pools;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileSearcher {

	public static void main(String[] args) throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter file name: ");
		String fileName = kb.nextLine();
		System.out.println("Start at : ");
		String startLoc = kb.nextLine();
		File startFolder = new File(startLoc);
		File[] contents = startFolder.listFiles();
		Queue<File> fileQueue = new ConcurrentLinkedQueue<File>();
		fileQueue.addAll(Arrays.asList(contents));
		List<File> results = Collections.synchronizedList(new ArrayList<File>());
		CountDownLatch latch = new CountDownLatch(2);
		SearchWorker w1 = new SearchWorker(fileName, fileQueue, results,latch);
		SearchWorker w2 = new SearchWorker(fileName, fileQueue, results,latch);
		ExecutorService pool = Executors.newFixedThreadPool(4);
		long start = System.currentTimeMillis();
		
		pool.execute(w1);
		pool.execute(w2);
		
		latch.await();
		
		
		long stop = System.currentTimeMillis();
		
		System.out.println("The search took "+(stop - start)+" ms.");
		System.out.println("There were "+results.size()+" matching files found.");
		for(File result : results){
			System.out.println(result.getAbsolutePath());
		}
		
		pool.shutdown();
	}

}





