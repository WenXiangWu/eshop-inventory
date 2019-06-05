package com.roncoo.eshop.inventory.thread;

import com.roncoo.eshop.inventory.request.Request;
import com.roncoo.eshop.inventory.request.RequestQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName RequestProcessorThreadPool
 * @Description 单例线程池；
 * @Author wuwenxiang
 * @Date 2019-06-05 22:20
 * @Version 1.0
 **/
public class RequestProcessorThreadPool {

    private static final int threadPoolSize = 10;

    /**
     * 在实际项目中，设置线程池大小是多少，每个线程监控的内存队列的大小是多少，
     * 都可以做到一个外部的配置文件中；
     * 这里做简化，直接写死；
     */
    private ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

    /**
     * 初始化内存队列；
     */
    private List<ArrayBlockingQueue<Request>> queueList = new ArrayList<>();

    /**
     * 单例，采取绝对线程安全的方式；
     * 通过静态内部类的方式去初始化单例；
     */
    private static class Singleton {
        private static RequestProcessorThreadPool instance;

        static {
            instance = new RequestProcessorThreadPool();
        }

        public static RequestProcessorThreadPool getInstance() {
            return instance;
        }
    }

    /**
     * 利用JVM的机制去保证多线程并发安全；
     * 内部类的初始化一定只会发生一次，不管多少个线程并发去初始化；
     *
     * @return
     */
    public static RequestProcessorThreadPool getInstance() {
        return Singleton.getInstance();
    }


    /**
     * 初始化的便捷方法；
     */
    public static void init() {
        getInstance();
    }


    /**
     * 做一些初始化的事情；
     */
    public RequestProcessorThreadPool() {
        for (int i = 0; i < threadPoolSize; i++) {
            ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(100);
            RequestQueues requestQueues = RequestQueues.getInstance();
            requestQueues.addQueue(queue);
            //将内存队列提交给后台工作线程去操作；
            executorService.submit(new RequestProcessorThread(queue));
        }
    }
}
