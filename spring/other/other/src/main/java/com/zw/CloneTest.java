package com.zw;

import java.io.Serializable;

public class CloneTest implements Cloneable, Serializable {
    private int i;

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "i=" + i +
                ",hashCode=" + hashCode() +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CloneTest cloneTest = new CloneTest();
        cloneTest.setI(i);
        return cloneTest;
    }
}
