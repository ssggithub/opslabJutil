package com.opslab.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 面试题： 设计一个缓存系统
 * @author Administrator
 *
 */
public class CacheDemo {

	Map<String, Object> cache = new HashMap<String, Object>();
    public static void main(String[] args) {

    }
    
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public Object getData(String key){
        rwl.readLock().lock(); 
        Object value = null;
        try {
            value = cache.get(key);
            if(value == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if(value == null){  //防止后边线程加载数据，使用双端检测机制
                        value = "xxx"; //queryDB
                        cache.put(key, value);
                    }
                }finally{
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        } catch (Exception e) {
        }finally{
            rwl.readLock().unlock();
        }
        return value;
    }

}
