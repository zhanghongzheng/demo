package com.test.zhz.demo.dataStructure;/**
 * Created by zhz on 18/6/14.
 */

/**
 * 功能:
 *
 * @author zhz
 * @date 18/6/14 下午6:44
 */
public class LinkNode {
    public int age;
    public String name;
    public LinkNode next;

    public LinkNode(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
