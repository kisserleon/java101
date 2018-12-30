package com.jacky.java101.annotation.class_retention_policy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@interface RetentionClass {

}

@Retention(RetentionPolicy.RUNTIME)
@interface RetentionRuntime {

}

@RetentionClass
class ClassRetention {

}

@RetentionRuntime
class RuntimeRetention {

}

public class Main {
    public static void main(String[] args) {

        System.out.println(String.format("C class annotations length: %d", ClassRetention.class.getAnnotations().length));
        System.out.println(String.format("D class annotations length: %d", RuntimeRetention.class.getAnnotations().length));
    }
}
