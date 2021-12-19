package com.lchy.principles._02里氏代换原则._02after;

public class Square implements Quadrilateral {
    //边长
    private double side;
    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
