package com.zw;

import java.util.*;

public class MyStack {
    public Queue<String> qu1;
    public Queue<String> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(String val) {
        if (!qu1.isEmpty()) {
            qu1.offer(val);
        } else if (!qu2.isEmpty()) {
            qu2.offer(val);
        } else {
            qu1.offer(val);
        }
    }

    public String pop() {
        if (qu1.isEmpty() && qu2.isEmpty()) {
            return null;
        }
        if (!qu1.isEmpty()) {
            int len = qu1.size();
            String cur;
            for (int i = 0; i < len - 1; i++) {
                cur = qu1.poll();
                qu2.offer(cur);
            }
            return qu1.poll();
        } else {
            int len = qu2.size();
            String cur;
            for (int i = 0; i < len - 1; i++) {
                cur = qu2.poll();
                qu1.offer(cur);
            }
            return qu2.poll();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push("1");
        myStack.push("2");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
