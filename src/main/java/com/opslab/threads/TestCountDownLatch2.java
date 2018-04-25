package com.opslab.threads;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch : 闭锁，在完成某些运算时，只有其他所有线程的运算全部完成，当前运算才继续执行
 * 
 * CountDownLatch应用1：比如要统计5个线程并发的运行时间，即线程的开始时间与最后一个线程的运行结束时间的间隔时间。
 * 
 * @author Administrator
 *
 */
public class TestCountDownLatch2 {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(5);
		LatchDemo2 ld = new LatchDemo2(latch);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			new Thread(ld).start();
		}
		try {
			latch.await(); // 先执行完成的线程需要等待还没有执行完的线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("cost: " + (end - start));
	}

}

class LatchDemo2 implements Runnable {
	private CountDownLatch latch;

	public LatchDemo2(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		try {
			synchronized (this) {
				for (int i = 0; i < 50000; i++) { // 找出50000以内的所有偶数
					if (i % 2 == 0) {
						System.out.println(i);
					}
				}
			}
		} finally {
			latch.countDown(); // 为了让这一句一定执行可以放在finally中
		}
	}

}
