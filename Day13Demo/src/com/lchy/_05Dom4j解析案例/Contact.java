package com.lchy._05Dom4j解析案例;

/**
     <contact id="1" vip="true">
         <name>潘金莲</name>
         <gender>女</gender>
         <email>panpan@itcast.com</email>
     </contact>
 */
public class Contact {
    private int id;
    private boolean vip;
    private String name;
    private char sex;
    private String email;

    public Contact() {
    }

    public Contact(int id, boolean vip, String name, char sex, String email) {
        this.id = id;
        this.vip = vip;
        this.name = name;
        this.sex = sex;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", vip=" + vip +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}
