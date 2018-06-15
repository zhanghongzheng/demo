package com.test.zhz.demo.dataStructure;/**
 * Created by zhz on 18/6/14.
 */

/**
 * 功能: 使用数组实现 栈(后进先出 LIFO) push,pop,peek
 * <p>
 * 检查{}()[]是否对称 (若发现它是左分隔符（{、[、(），将它压入栈中。当读到一个右分隔符时（)、]、}），弹出栈顶元素)
 * 因对称特性正好符合--后进先出
 *
 * @author zhz
 * @date 18/6/14 上午11:23
 */
public class Stack {
    private int size;
    private int top;
    private char[] stackArray;

    public Stack(int size) {
        this.stackArray = new char[size];
        this.size = size;
        this.top = -1;
    }

    public void push(char c) {
        this.stackArray[++top] = c;
    }

    public char pop() {
        return this.stackArray[top--];
    }

    public char peek() {
        return this.stackArray[top];
    }

    public boolean isFull() {
        return (top == this.size);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public static boolean checkJava(String j) {
        Stack stack = new Stack(j.length());
        for (int i = 0; i < j.length(); i++) {
            char c = j.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.pop() != '{') {
                        System.out.println("{} 未对称");
                        return false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        System.out.println("[] 未对称");
                        return false;
                    }
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        System.out.println("() 未对称");
                        return false;
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("有符合没有结束符");
        }
        return true;
    }

    public static void main(String[] args) {
        Stack.checkJava("if(i:s[]){i>0}{");
    }
}
