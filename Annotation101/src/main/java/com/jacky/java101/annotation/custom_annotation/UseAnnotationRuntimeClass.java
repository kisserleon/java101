package com.jacky.java101.annotation.custom_annotation;

import java.lang.annotation.Annotation;

public class UseAnnotationRuntimeClass {
    public static void main(String[] args) {
        Class<MyAnnotationRuntimeClass> element = MyAnnotationRuntimeClass.class;
        try {
            System.out.println("Annotation element values: \n");
            if (element.isAnnotationPresent(RuntimeClassComment.class)) {
                Annotation singleAnnotation =
                        element.getAnnotation(RuntimeClassComment.class);
                RuntimeClassComment comment = (RuntimeClassComment) singleAnnotation;

                System.out.println("Author: " + comment.author());
                System.out.println("Date: " + comment.date());
                System.out.print("Reviewers: ");
                for (String member : comment.reviewers())
                    System.out.print(member + ", ");
                System.out.print("\n");
                System.out.println("Revision: " + comment.revision());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
