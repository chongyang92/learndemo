package com.lchy._08反射有啥用;

public class Pig {
    private String name;
    private double weight;
    private String color;
    private String owner;
    private String sex;

    public Pig() {
    }

    public Pig(String name, double weight, String color, String owner, String sex) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.owner = owner;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
