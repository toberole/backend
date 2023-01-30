package com.zw;

import javax.security.auth.callback.Callback;
import java.util.*;

public abstract class Test1 {
    public static void main(String[] args) {
        int i = 4;
        System.out.println(i >> 1);

//        Queue<String> queue = new LinkedList<String>();
//        queue.offer("string"); // add
//        System.out.println(queue.poll());
////        System. out. println(queue. remove());
//        System.out.println(queue.size());

//        List<String> list = new LinkedList<String>();
//        list.add("123");

        List<String> list = new ArrayList<>();
        list. add("x");
        Collection<String> clist = Collections.unmodifiableCollection(list);
        clist. add("y"); // 运行时此行报错
        System. out. println(list. size());

//        new Thread(new Callback(){}).start();
    }

    public void test1() {
        System.out.println("Hello");

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello World!");

        Map<String, String> map = new HashMap<>();
        map.put("hello", "world!");

        Set<String> set = new HashSet<>();
        set.add("Hello");

        String arr[] = new String[5];
        List<String> list1 = Arrays.asList(arr);

        Vector<String> vector = new Vector<>();
        vector.add("Hello");

    }
}
