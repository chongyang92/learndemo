package com.lchy.principles._02里氏代换原则._02after;

public class Rectangle implements Quadrilateral {
    private double length;
    private double width;
    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
