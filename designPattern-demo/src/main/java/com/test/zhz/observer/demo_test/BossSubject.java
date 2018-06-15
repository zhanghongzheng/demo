package com.test.zhz.observer.demo_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhz on 18/1/26.
 */
public class BossSubject extends Subject {
    private static List<Observer> observerList = new ArrayList<Observer>();
    private String bossStatus;
    private String name;

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifiyAll() {
        for(Observer observer:observerList){
            observer.update(this,this.getBossStatus());
        }
    }


    public String getBossStatus() {
        return bossStatus;
    }

    public void setBossStatus(String bossStatus) {
        this.bossStatus = bossStatus;
    }

}
