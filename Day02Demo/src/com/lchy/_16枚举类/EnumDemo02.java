package com.lchy._16枚举类;

/**
    目标：枚举类用于做信息标志和信息分类
        超级玛丽的上下左右键,
            整型值做分类；含义不明确
            常量；入参不受控制
 */

enum Oritation{
    UP,DOWN,LEFT,RIGHT;
}
public class EnumDemo02 {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static void main(String[] args) {
        moveZX(0);//数值
        moveCL(UP);//这里换成 move(0);也一样，但常量入参不受控制
        moveEnum(Oritation.UP);//枚举
    }

    //控制玛丽的移动,整型数值
    public static void moveZX(int oritation){
        switch (oritation){
            case 0:
                System.out.println("玛丽上跳");
                break;
            case 1:
                System.out.println("玛丽下蹲");
                break;
            case 2:
                System.out.println("玛丽左");
                break;
            case 3:
                System.out.println("玛丽右");
                break;
        }
    }
    //常量
    public static void moveCL(int oritation){
        switch (oritation){
            case UP:
                System.out.println("玛丽上跳");
                break;
            case DOWN:
                System.out.println("玛丽下蹲");
                break;
            case LEFT:
                System.out.println("玛丽左");
                break;
            case RIGHT:
                System.out.println("玛丽右");
                break;
        }
    }
    //枚举
    public static void moveEnum(Oritation oritation){
        switch (oritation){
            case UP:        //这里不用写Oritation.UP ,switch已经知道是枚举类型了
                System.out.println("玛丽上跳");
                break;
            case DOWN:
                System.out.println("玛丽下蹲");
                break;
            case LEFT:
                System.out.println("玛丽左");
                break;
            case RIGHT:
                System.out.println("玛丽右");
                break;
        }
    }
}


