package com.lchy._11注解的属性;

/**
    目标：注解的属性

    属性的格式：默认带public
            - 格式1：数据类型 属性名();
            - 格式2：数据类型 属性名() default 默认值;

    属性适用的数据类型：
            八种基本数据类型(int ,short, long, double, byte, char, boolean, float)
            String, Class
            以上类型都支持

    小结：
        注解可以有属性，属性名必须带()
        在用注解的时候，属性必须赋值，除非这个属性有默认值！
 */
@MyBook(name="《精通MySQL》",authors = {"张三","李四"},price = 55.6)
public class AnnotationDemo01 {
    @MyBook(name="《精通MySQL》",authors = {"张三","李四"},price = 55.6,
    address = "南京")
    public static void main(String[] args) {

    }
}

//自定义一个注解
@interface MyBook{
    String name();
    String[] authors();//数组
    double price();
    String address() default "北京";

}
