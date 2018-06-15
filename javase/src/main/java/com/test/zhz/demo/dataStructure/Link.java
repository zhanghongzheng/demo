package com.test.zhz.demo.dataStructure;/**
 * Created by zhz on 18/6/14.
 */

/**
 * 功能:
 *
 * @author zhz
 * @date 18/6/14 下午6:44
 */
public class Link {
    private LinkNode first;
    public void insertFirst(LinkNode node){
        LinkNode next = first;
        first = node;
        first.next=next;
    }
    public void removeFirst(){
        if (first!=null){
            first = first.next;
        }
    }

    public LinkNode popFirst(){
        if (first!=null){
            LinkNode pop = first;
            first = first.next;
            return pop;
        }
        return null;
    }

    public LinkNode find(String name){
        if (first==null){
            return null;
        }
        if(first.name.equals(name)){
           return first;
        }
        while (first.next!=null){
            if (first.next.name.equals(name)){
                return first.next;
            }else {
                first = first.next;
            }
        }
        return null;
    }


}
