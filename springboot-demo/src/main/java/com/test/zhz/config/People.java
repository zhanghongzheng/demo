package com.test.zhz.config;
/**
 * Created by zhz on 18/5/29.
 */

import java.util.List;


/**
 * 功能:
 *
 * @author zhz
 * @date 18/5/29 下午6:13
 */
public class People {
    private String name;

    private Integer age;

    private List<String> address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
