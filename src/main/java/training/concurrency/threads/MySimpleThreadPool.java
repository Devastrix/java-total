package training.concurrency.threads;

import java.io.File;
import java.util.*;

public class MySimpleThreadPool {

    /*
    name of the file
    Start of the folder
     */

    public static void main(String[] args) throws InterruptedException {
        String fileName = "wifipass.png";
        String startLoc = "Z:\\workz";
        File file = new File(startLoc);
        File[] contents = file.listFiles();
        Queue<File> fileQueue = new LinkedList<>();
        fileQueue.addAll(Arrays.asList(contents));

        //Syncronized wrapper!
        List<File> results = Collections.synchronizedList(new ArrayList<>());

        Thread thread = getMeSimpleThread(fileName, fileQueue, results);
        Thread thread1 = getMeSimpleThread(fileName, fileQueue, results);
        Thread thread2 = getMeSimpleThread(fileName, fileQueue, results);

        long startTime, time;
        startTime = System.currentTimeMillis();
        thread.start();
        thread1.start();
        thread2.start();

        thread.join();
        thread1.join();
        thread2.join();
        System.out.println("\n There were " + results.size() + " matching files found");
        for(File result: results){
            System.out.println(result.getAbsoluteFile());
        }
        time = System.currentTimeMillis() - startTime;
        System.out.println("Single thread  " + Thread.currentThread().getName() + " execution time: " + time + "ms");

    }

    private static Thread getMeSimpleThread(String fileName, Queue<File> fileQueue, List<File> results) {
        return new Thread(new Runnable() {
            @Override
            public void run() {

                while (fileQueue.size()>0){
                    File currentFile = fileQueue.remove();
                    System.out.println("Working on file "+ currentFile.getAbsolutePath());
                    if(currentFile.isDirectory()){
                        try {
                            fileQueue.addAll(Arrays.asList(Objects.requireNonNull(currentFile.listFiles())));
                        }catch (Exception e){
                            //ignore
                        }
                    }else{
                        if(currentFile.getName().equals(fileName)){
                            results.add(currentFile.getAbsoluteFile());
                        }
                    }
                }
            }
        });
    }
}
