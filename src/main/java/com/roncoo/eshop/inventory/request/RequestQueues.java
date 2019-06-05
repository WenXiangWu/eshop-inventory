package com.roncoo.eshop.inventory.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName RequestQueues
 * @Description 请求内存队列；
 * @Author wuwenxiang
 * @Date 2019-06-05 22:40
 * @Version 1.0
 **/
public class RequestQueues {
    /**
     * 初始化内存队列；
     */
    private List<ArrayBlockingQueue<Request>> queueList = new ArrayList<>();

    private static class Singleton {
        private static RequestQueues instance;

        static {
            instance = new RequestQueues();
        }

        public static RequestQueues getInstance() {
            return instance;
        }
    }

    public static RequestQueues getInstance() {
        return Singleton.getInstance();
    }

    /**
     * 1.添加一个内存队列；
     *
     * @param queue
     */
    public void addQueue(ArrayBlockingQueue<Request> queue) {
        this.queueList.add(queue);

    }
}
