package com.roncoo.eshop.inventory.listener;

import com.roncoo.eshop.inventory.thread.RequestProcessorThreadPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName InitListener
 * @Description 系统初始化监听器；
 * @Author wuwenxiang
 * @Date 2019-06-05 22:17
 * @Version 1.0
 **/
public class InitListener implements ServletContextListener {

    /**
     * 初始化工作线程池和内存队列；
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //RequestProcessorThreadPool pool = RequestProcessorThreadPool.getInstance();
        //初始化d
        RequestProcessorThreadPool.init();
        System.out.println("系统初始化");
    }
}
