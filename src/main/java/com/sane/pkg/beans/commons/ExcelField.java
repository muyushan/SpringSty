package com.sane.pkg.beans.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelField {

    String displayName() default "";

    enum  FieldType{INT,DOUBLE,STRING,DATETIME};

    FieldType fieldType() default FieldType.STRING;

    boolean isRequired() default true;


}
