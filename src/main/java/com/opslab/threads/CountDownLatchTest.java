package com.opslab.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1000);
        for(int i=0;i<1000;i++){
            new Thread(){
                public void run() {
                    try {
                        Thread.sleep(3000);
                        long se = System.currentTimeMillis();
                        System.out.println(se);
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
            }.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
