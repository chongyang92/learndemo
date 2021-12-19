package com.lchy.principles._01开闭原则;

public class Client {
    public static void main(String[] args) {
        //1.创建搜狗输入法对象
        SougouInput sougouInput = new SougouInput();
        //2.创建皮肤对象
        //DefaultSkin skin = new DefaultSkin();
        //HeimaSkin skin = new HeimaSkin();
        AbstractSkin skin = new HeimaSkin();
        //3.将皮肤设置到输入法中
        sougouInput.setSkin(skin);
        //4.显示皮肤
        sougouInput.display();
    }
}
