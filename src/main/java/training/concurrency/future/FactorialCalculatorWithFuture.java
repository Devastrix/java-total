package training.concurrency.future;

import java.math.BigInteger;
import java.util.concurrent.*;

public class FactorialCalculatorWithFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int num=1000;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        FactorialCalculator factorialCalculator = new FactorialCalculator(num);
        Future<BigInteger> fut = executorService.submit(factorialCalculator);
        executorService.shutdown();
        System.out.println("The computed factorial of "+num+ " : "+fut.get().toString());
    }
}

class FactorialCalculator implements Callable<BigInteger>{

    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public BigInteger call() throws Exception {
        BigInteger fact = new BigInteger(String.valueOf(1));
        BigInteger inc = new BigInteger(String.valueOf(1));

        for (int i = 1; i < number; i++) {
            fact = fact.multiply(inc);
            inc = inc.add(BigInteger.ONE);
//            Thread.sleep(40);
        }
        return fact;
    }
}
