package com.opslab.threads;

import java.util.concurrent.*;

public class TestFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future result1 = executor.submit(new Callable() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 10; i++) {

                    sum += i;
                }
                return sum;
            }
        });

        Future result2 = executor.submit(new Callable() {

            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 10; i < 100; i++) {
                    sum += i;
                }
                return sum;
            }

        });
        executor.shutdown();

        System.out.println((int)result1.get() +","+ (int)result2.get());

    }

}
