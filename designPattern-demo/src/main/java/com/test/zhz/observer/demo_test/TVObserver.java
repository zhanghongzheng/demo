package com.test.zhz.observer.demo_test;

/**
 * Created by zhz on 18/1/26.
 */
public class TVObserver implements Observer {
    @Override
    public void update(Subject subject, Object data) {
        System.out.println(subject);
    }
}
