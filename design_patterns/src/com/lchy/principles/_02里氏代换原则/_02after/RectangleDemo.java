package com.lchy.principles._02里氏代换原则._02after;

public class RectangleDemo {
    public static void main(String[] args) {
        //创建长方形对象
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        //调用方法进行扩宽操作
        resize(rectangle);
        printLengthAndWidth(rectangle);
    }
    public static void resize(Rectangle rectangle){
        //判断宽如果比长小，进行扩宽的操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public static void printLengthAndWidth(Quadrilateral quadrilateral){
        System.out.println(quadrilateral.getLength());
        System.out.println(quadrilateral.getWidth());
    }
}
