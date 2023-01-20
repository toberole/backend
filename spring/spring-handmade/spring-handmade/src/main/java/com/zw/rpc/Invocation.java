package com.zw.rpc;

import java.io.Serializable;
import java.lang.reflect.Method;

public class Invocation implements Serializable {
    public Class serviceClass;
    public String methodName;
    public Object parameter[];
    public Class parameterTypes[];
}
