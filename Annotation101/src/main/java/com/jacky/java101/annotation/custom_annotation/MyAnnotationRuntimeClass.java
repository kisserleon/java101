package com.jacky.java101.annotation.custom_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface RuntimeClassComment {
    String author();
    String date();
    int revision() default 1;
    String[] reviewers();
}

@RuntimeClassComment(
        author = "Jacky Han",
        date = "30/12/2018",
        revision = 3,
        reviewers = { "nobody", "jacky" })
public class MyAnnotationRuntimeClass {
}
