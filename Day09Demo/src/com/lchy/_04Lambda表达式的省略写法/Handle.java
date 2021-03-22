package com.lchy._04Lambda表达式的省略写法;

public class Handle implements MyInterface{
    public Handle(){

    }
    public Handle(MyInterface myInterface){
        myInterface.show();
        myInterface.test(null);
    }

    @Override
    public void test(String s) {
        System.out.println("Handle test");
    }
}
