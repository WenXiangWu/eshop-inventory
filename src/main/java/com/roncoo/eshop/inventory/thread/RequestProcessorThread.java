package com.roncoo.eshop.inventory.thread;

import com.roncoo.eshop.inventory.request.Request;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * @ClassName RequestProcessorThread
 * @Description 执行请求的工作线程
 * @Author wuwenxiang
 * @Date 2019-06-05 22:35
 * @Version 1.0
 **/
public class RequestProcessorThread implements Callable {

    /**
     * 后台线程，去监控内存队列；
     */
    private ArrayBlockingQueue<Request> queue;

    /**
     * 初始化一个内存队列；
     * @param queue
     */
    public RequestProcessorThread(ArrayBlockingQueue<Request> queue){
        this.queue = queue;
    }
    @Override
    public Object call() throws Exception {
        //每个线程都是后台线程；
        while (true){
            //不断的处理内存队列中的请求；
            break;
        }

        return true;
    }
}
