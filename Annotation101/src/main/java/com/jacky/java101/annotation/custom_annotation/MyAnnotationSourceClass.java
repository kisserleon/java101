package com.jacky.java101.annotation.custom_annotation;

import java.lang.annotation.Documented;

@Documented
@interface ClassComment {
    String author();
    String date();
    int revision() default 1;
    String[] reviewers();
}

@ClassComment(
        author = "Jacky Han",
        date = "30/12/2018",
        revision = 3,
        reviewers = {"nobody", "jacky"}
)
public class MyAnnotationSourceClass {
}
