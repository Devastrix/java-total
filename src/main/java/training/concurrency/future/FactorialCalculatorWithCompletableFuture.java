package training.concurrency.future;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactorialCalculatorWithCompletableFuture {

    public BigInteger calculateFactorial(int number) {
        BigInteger fact = BigInteger.valueOf(1);
        BigInteger inc = new BigInteger(String.valueOf(1));

        for (int i = 1; i < number; i++) {
            fact = fact.multiply(inc);
            inc = inc.add(BigInteger.ONE);
        }
        return fact;
    }

    public void displayFactorial(BigInteger bigInteger) {
        System.out.println("Displaying factorial in thread: " + Thread.currentThread().getName() + " is : " + bigInteger.toString());
    }

    public void testCF() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture
                .supplyAsync(() -> calculateFactorial(1000), executorService)
                .thenAcceptAsync(this::displayFactorial, executorService);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FactorialCalculatorWithCompletableFuture obj = new FactorialCalculatorWithCompletableFuture();
        obj.testCF();
    }
}
