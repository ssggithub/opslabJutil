package com.opslab.threads;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 简单的读写锁示例
 * @author Administrator
 *
 */
public class TestReadWriteLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        new Thread(new Runnable(){
            @Override
            public void run() {
                demo.set(new Random().nextInt(5000));
            }
        },"Write").start();
        
        for(int i = 0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.get();
                }
            }, "Read").start();
        }
	}

}

class ReadWriteLockDemo{
    private int number = 0;
    
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    
    public void get(){
        try{
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() +" "+number);
        }finally{
            lock.readLock().unlock();
        }
    }
    public void set(int number){
        try{
            lock.writeLock().lock();
            this.number = number;
        }finally{
            lock.writeLock().unlock();
        }
    }
}