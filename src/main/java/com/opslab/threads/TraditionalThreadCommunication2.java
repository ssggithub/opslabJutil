package com.opslab.threads;

/**
 * 传统线程通信 主线程和子线程分别打印 100次 和 10次，循环50次
 * 
 * @author Administrator
 *
 */
public class TraditionalThreadCommunication2 {

	public static void main(String[] args) {
		final Buiness buiness = new Buiness();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					buiness.sub(i);
				}
			}
		}).start();

		for (int i = 1; i <= 50; i++) {
			buiness.main(i);
		}
	}

	static class Buiness {
		private boolean isShouldSub = false; // 主线程先打印

		public synchronized void main(int j) { // 进行同步，防止在打印时被其他线程干扰
			while (isShouldSub) { // 这里使用while 防止假唤醒
				try {
					this.wait(); // wait() 和 notify() 必须出现在synchronized同步中
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= 100; i++) {
				System.out.println("main thread print " + i + " loop of " + j);
			}
			isShouldSub = true;
			this.notify();
		}

		public synchronized void sub(int j) {
			while (!isShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= 10; i++) {
				System.out.println("sub thread print " + i + " loop of " + j);
			}
			isShouldSub = false;
			this.notify();
		}
	}

}
