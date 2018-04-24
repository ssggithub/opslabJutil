package com.opslab.threads;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author Administrator 读写锁：分为读锁和写锁，多个读锁不互斥，读锁与写锁互斥，这是由jvm自己控制的，你只要上好相应的锁即可。
 *         如果你的代码只读数据，可以很多人同时读，但不能同时写，那就上读锁； 如果你的代码修改数据，只能有一个人在写，且不能同时读取，那就上写锁。
 *         总之，读的时候上读锁，写的时候上写锁！
 */
public class ReadWriteLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Queue3 queue = new Queue3();

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						queue.get();
					}
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					queue.set(new Random().nextInt(10000));
				}
			}).start();
		}
	}

}

class Queue3 {
	private Object data = null; // 共享数据 ，只能有一个线程写该数据，但可以有多个线程同时读
	ReadWriteLock rwl = new ReentrantReadWriteLock(); // 读写锁

	public void get() {
		try {
			rwl.readLock().lock(); // 上读锁 可以有多个线程同时读
			System.out.println(Thread.currentThread().getName() + " be ready to read data!");
			Thread.sleep((long) Math.random() * 1000);
			System.out.println(Thread.currentThread().getName() + " have read data : " + data);
		} catch (InterruptedException e) {
		} finally {
			rwl.readLock().unlock(); // 释放读锁
		}
	}

	public void set(Object data) {
		try {
			rwl.writeLock().lock(); // 添加写锁，保证只能有一个线程进行写操作
			System.out.println(Thread.currentThread().getName() + " be read to write data: " + data);
			Thread.sleep((long) Math.random() * 1000);
			this.data = data;
			System.out.println(Thread.currentThread().getName() + "has write data");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rwl.writeLock().unlock(); // 释放写锁
		}
	}
}