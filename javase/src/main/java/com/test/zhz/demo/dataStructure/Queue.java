package com.test.zhz.demo.dataStructure;/**
 * Created by zhz on 18/6/14.
 */

/**
 * 功能: 队列(先进先出 FIFO)
 *   https://blog.csdn.net/u012152619/article/details/41799569
 *   使用数组实现(从0开始移动指针实现先进先出,但是数组有size,指针移动到最后之后,前面的空间都无法访问了)
 *   通过环绕式处理实现 循环队列
 *
 * @author zhz
 * @date 18/6/14 下午3:27
 */
public class Queue {
    private int maxSize;
    private int first=-1;
    private int last;
    private int length;
    private Object[] queueArray;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.first = 0;
        this.last = 0;
        this.length = 0;
        this.queueArray = new Object[maxSize];
    }

    public void add(Object elem){
        if(this.isFull()){
            throw new RuntimeException("已经满了");
        }
        if(last==maxSize){
            last = 0;
        }
        this.queueArray[last++] = elem;
        length++;
    }

    public Object remove(){
        if(this.isEmpty()){
            throw new RuntimeException("已经没有了");
        }
        if(first==maxSize-1){
            first = -1;
        }
        length--;
        return this.queueArray[++first];
    }

    public boolean isFull(){
        return this.length==this.maxSize;
    }

    public boolean isEmpty(){
        return this.length==0;
    }


    public static void main(String[] args) {

    }

}
