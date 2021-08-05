package com.lchy._12注解的特殊属性_value;

import org.junit.Before;

import java.beans.ConstructorProperties;

/**
    目标：注解的特殊属性名称：value
        value属性，如果只有一个value属性的情况下，
        使用value属性的时候可以省略value名称不写！

        但是如果有多个属性，且多个属性没有默认值，那么value是不能省略的。
 */
//@BooK(value = "/login")
@BooK("/login")      //value属性可以省略不写
@BooK1(age=4,value = "haha")      //不止value时，必须写明value
public class AnnotationDemo01 {
}

@interface BooK{
    String value();
}

@interface BooK1{
    String value();
    int age();
}
