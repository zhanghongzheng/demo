package com.test.zhz.observer.demo_test;

/**
 * Created by zhz on 18/1/26.
 */
public abstract class Subject {

    abstract void addObserver(Observer observer);

    abstract void removeObserver(Observer observer);

    abstract void notifiyAll();

}
