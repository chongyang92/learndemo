package com.lchy.principles._02里氏代换原则._01before;

public class RectangleDemo {
    public static void main(String[] args) {
        //创建长方形对象
        Rectangle rectangle = new Rectangle();
        //设置长和宽
        rectangle.setLength(20);
        rectangle.setWidth(10);
        //调用resize进行扩宽
        resize(rectangle);
        printLengthWidth(rectangle);

        System.out.println("===============");
        //创建正方形对象
        Square square = new Square();
        square.setLength(10);
        //调用resize进行扩宽
        resize(square);
        printLengthWidth(square);
    }
    //扩宽方法
    public static void resize(Rectangle rectangle){
        //判断宽如果比长小，进行扩宽的操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    //打印长和宽
    public static void printLengthWidth(Rectangle rectangle){
        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getWidth());
    }
}
