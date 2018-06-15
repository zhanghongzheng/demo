package com.test.zhz.demo.guava;

import java.util.concurrent.ConcurrentMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by zhz on 18/1/12.
 */
public class TestGuava {
    //key-value(serverice,qps)
    private static final ConcurrentMap<String, Double> resourceMap = Maps.newConcurrentMap();
    //userkey-service limiter
    private static final ConcurrentMap<String, RateLimiter> userresourceLimiterMap = Maps.newConcurrentMap();
    static {
        //init
        resourceMap.put("aaa", 5.0);
    }
    public static void updateResourceQps(String resource, double qps) {
        resourceMap.put(resource, qps);
    }

    public static void removeResource(String resource) {
        resourceMap.remove(resource);
    }

    public static int enter(String resource,String userkey)  {
        long t1 = System.currentTimeMillis();
        double qps = resourceMap.get(resource);
        //服务不限流
        if (qps == 0.0) {
            return 0;
        }
        String keyser = resource+userkey;
        RateLimiter keyserlimiter = userresourceLimiterMap.get(keyser);
        //if null,new limiter
        if(keyserlimiter == null)
        {
            keyserlimiter =RateLimiter.create(qps);
            RateLimiter putByOtherThread = userresourceLimiterMap.putIfAbsent(keyser, keyserlimiter);
            if (putByOtherThread != null) {
                keyserlimiter = putByOtherThread;
            }
            keyserlimiter.setRate(qps);
        }
        keyserlimiter.acquire();

        //tryacquire
        if (!keyserlimiter.tryAcquire()) {
            System.out.println("use:"+(System.currentTimeMillis()-t1)+"ms;"+resource+"  visited  too frequently  by key:"+userkey);

            return 99;
        }else{
            System.out.println("use:"+(System.currentTimeMillis()-t1)+"ms;");
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

//        RateLimiter rateLimiter = RateLimiter.create(5);
        long startTime = System.nanoTime();
        // ... the code being measured ...
        long estimatedTime = System.nanoTime() - startTime;


        int i=0;
//
        while(true){
            i++;
            long t2 = System.currentTimeMillis();
            System.out.println(t2+":qq:"+i);

            int res =   TestGuava.enter("aaa", "qq");
            System.out.println((System.currentTimeMillis()-t2)+":qq:"+i);
            if(res ==99)
            {
                i=0;
                Thread.sleep(1000);
            }
            return;
        }

    }

    static class TestA{
        private static RateLimiter one=RateLimiter.create(2);//每秒2个

        private static RateLimiter two=RateLimiter.create(2);//每秒2个

        private TestA(){};


        public static void acquire(RateLimiter r,int num){

            double time = r.acquire(num);
            r.tryAcquire();
            System.out.println("wait time="+time);
        }

        public static void main(String[] args) throws InterruptedException {
            acquire(one,1);
            acquire(one,1);
//            acquire(one,1);
//            System.out.println("-----");
//            acquire(two,10);
//            acquire(two,1);

        }
    }
}
