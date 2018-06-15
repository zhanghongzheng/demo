//package com.test.zhz.demo.java8;/**
// * Created by zhz on 18/5/29.
// * 1.8多了一个概念就是FunctionalInterface
//    有了这个注解，原来使用实现类的地方就可以代之以lambda表达式。
// */
//
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 功能:
// * https://blog.csdn.net/bitcarmanlee/article/details/70195403
// *
// * @author zhz
// * @date 18/5/29 上午10:55
// */
//public class testLambda {
//
//    //1.替代匿名内部类
//    //如果使用匿名内部类：
//    @Test
//    public static void oldRunable() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("The old runable now is using!");
//            }
//        }).start();
//    }
//
//    //而如果使用lambda表达式：
//    @Test
//    public static void runable() {
//        new Thread(() -> System.out.println("It's a lambda function!")).start();
//    }
//
//    //    2.使用lambda表达式对集合进行迭代
//    @Test
//    public void iterTest() {
//        List<String> languages = Arrays.asList("java", "scala", "python");
//        //before java8
//        for (String each : languages) {
//            System.out.println(each);
//        }
//        //after java8
//        languages.forEach(x -> System.out.println(x));
//        languages.forEach(System.out::println);
//    }
//
//    @Test
//    public void mapTest() {
//        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
//        cost.stream().map(x -> x + x * 0.05).forEach(x -> System.out.println(x));
//    }
//
//    public static void main(String[] args) {
//        testLambda.oldRunable();
//        testLambda.runable();
//
//    }
//}
