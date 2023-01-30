package com.zw;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack1<T> {
    public Queue<T> in;
    public Queue<T> out;

    public MyStack1() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(T val) {
        if (null == val) {
            return;
        }

        if (!out.isEmpty()) {
            out.offer(val);
            return;
        }

        in.offer(val);
    }

    public T pop() {
        if (!out.isEmpty()){
            out.poll()
        }
        return null;
    }

    public static void main(String[] args) {
        MyStack1 myStack = new MyStack1();

        myStack.push("1");
        myStack.push("2");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
