package com.lchy.principles._02里氏代换原则._01before;

/**
 * 正方形类
 */
public class Square extends Rectangle {
    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public Number getAge(int a) {
        return a;
    }
}
