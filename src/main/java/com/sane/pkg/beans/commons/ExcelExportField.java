package com.sane.pkg.beans.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelExportField {

    String displayName();

    enum  FieldType{INT,DOUBLE,STRING,DATETIME,SHORT};

    FieldType fieldType() default FieldType.STRING;

    String formatPatten() default "yyyy-MM-dd HH:mm:ss";


}
