package com.lchy._09接口的多实现;
/**
    接口的多实现

    类实现接口的格式：
    修饰符  class 实现类名称  implements 接口1，接口2，接口3.。。{

    }
    implements：类实现接口的关键字。

    总结：
    一个类实现多个接口，必须重写完全部接口中的全部抽象方法，否则这个类要定义成抽象类
 */
public class InterfaceDemo {
}

class BasketBall implements SportMan,Law{

    @Override
    public void run() {

    }

    @Override
    public void competition() {

    }

    @Override
    public void rule() {

    }
}

interface SportMan{
    void run();
    void competition();
}

interface Law{
    void rule();
}
