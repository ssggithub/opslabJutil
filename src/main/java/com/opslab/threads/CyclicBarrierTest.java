package com.opslab.threads;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 表示大家彼此等待，大家集合好后才开始出发，分散活动后又在指定地点集合碰面， 这就好比整个公司的人员利用周末时间集体郊游一样，先各自从家出发到公司集合后，
 * 再同时出发到公园游玩，在指定地点集合后再同时开始就餐，…。
 * 
 * @author Administrator
 *
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(
								"线程" + Thread.currentThread().getName() + "即将到达集合点1,当前已有 " + (cb.getNumberWaiting() + 1)
										+ "个已经到达，" + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等待"));
						cb.await();

						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(
								"线程" + Thread.currentThread().getName() + "即将到达集合点2,当前已有 " + (cb.getNumberWaiting() + 1)
										+ "个已经到达，" + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等待"));
						cb.await();

						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(
								"线程" + Thread.currentThread().getName() + "即将到达集合点3,当前已有 " + (cb.getNumberWaiting() + 1)
										+ "个已经到达，" + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊" : "正在等待"));
						cb.await();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			};
			threadPool.execute(runnable);
		}
		threadPool.shutdown();
	}

}
