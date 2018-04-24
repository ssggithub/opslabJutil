package com.opslab.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Administrator java.util.concurrent.Lock
 *         Lock比传统线程模型中的synchronized方式更加面向对象，与生活中的锁类似，
 *         锁本身也应该是一个对象。两个线程执行的代码片段要实现同步互斥的效果，它们必须用同一个Lock对象。
 * 
 *         lock替代synchronized
 */
public class Outputer {
	Lock lock = new ReentrantLock();

	public void output(String name) {
		int len = name.length();
		lock.lock();
		try {
			for (int i = 0; i < len; i++) {
				char c = name.charAt(i);
				System.out.print(c);
			}
		} finally {
			lock.unlock(); // 这里防止内部代码出现异常，即无论如何最后都会释放锁
			System.out.println();
		}
	}
}
