package org.example;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.CLASS;

@Retention(CLASS)
public @interface JavaAnnotationWithList {
    String[] testList();
}
