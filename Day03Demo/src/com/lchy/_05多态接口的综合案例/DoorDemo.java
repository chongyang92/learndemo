package com.lchy._05多态接口的综合案例;

/**
    目标：门和门铃

    想象一个家庭的所有门，门有材质、品牌、安装位置（大门、屋门、厨房），可以开、关，高级一点安全门有密码锁还可以报警。


 */
public class DoorDemo {
    public static void main(String[] args) {
        //买门，能开能关就行
        System.out.println("---------买一个能开能关的门---------");
        Door door = HouseDoor.getInstance();
        door.open();
        door.close();
        System.out.println("------买一个西门子钛合金大门");
        System.out.println("-------后悔了,换,想买一个--------");
        HouseDoor houseDoor = HouseDoor.getInstance("大门",Brand.TAOHUAYUAN,"梨花木");
        Belling belling = new MusicBell();
        System.out.println(houseDoor.getMaterial());//这里是梨花木的，因为只产生一个
        houseDoor.partsTogether();
        houseDoor.install(belling);
        houseDoor.password();
        houseDoor.open();
        houseDoor.callPolice();
        houseDoor.close();

    }


}

//大门
class HouseDoor extends AbstractDoor implements Door,Safable{

    private String location;//大门、屋门、厨房门

    public static HouseDoor houseDoor ;//单例模式之懒汉模式——静态类变量

    private Brand brand;//品牌

    private HouseDoor(){
        this("大门",Brand.XIMENZI,"钛合金");
    }

    private HouseDoor(String material){
        this("大门",Brand.XIMENZI,material);
    }

    private HouseDoor(String location,Brand brand,String material){//单例模式之懒汉模式——私有构造器
        super(material);
        this.location = location;
        this.brand = brand;
    }

    @Override
    public void partsTogether() {
        System.out.println("门买回来了，把手螺丝组装，安到大门处");
    }

    public static HouseDoor getInstance(String location,Brand brand,String material){//单例模式之懒汉模式——静态获取实例方法
        if(houseDoor == null){
            houseDoor = new HouseDoor(location,brand,material);
        }
        return houseDoor;
    }
    public static HouseDoor getInstance(String material){//单例模式之懒汉模式——静态获取实例方法
        if(houseDoor == null){
            houseDoor = new HouseDoor(material);
        }
        return houseDoor;
    }

    public static HouseDoor getInstance(){//单例模式之懒汉模式——静态获取实例方法
        if(houseDoor == null){
            houseDoor = new HouseDoor();
        }
        return houseDoor;
    }

    @Override
    public void password() {
        System.out.println(getInfo()+"进门输入密码");
    }

    @Override
    public void callPolice() {
        System.out.println(getInfo()+"密码输入错误3次后自动报警");
    }

    @Override
    public void open() {
        System.out.println(getInfo()+"开了");
    }

    @Override
    public void close() {
        System.out.println(getInfo()+"关了");
    }

    public void install(Belling belling){
        System.out.println("门铃安好了");
        belling.sound();
    }

    public String getInfo(){
        return brand + getMaterial() + location + ": ";
    }
}

//将门抽象出材质属性和组装方法
abstract class AbstractDoor{
    private String material;

    public AbstractDoor(){

    }
    public AbstractDoor(String material){
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //组装
    public abstract void partsTogether();
}

//门最基本的功能，开、关
interface Door{
    void open();
    void close();
}

//安全的门有密码和自动报警功能
interface Safable{
    void password();
    void callPolice();
}

enum Brand{
    XIMENZI,XIAOMI,TAOHUAYUAN;
}

//门上安装音乐门铃
class MusicBell implements Belling{

    @Override
    public void sound() {
        System.out.println("一首好运来唱了起来");
    }
}

//门上安装普通门铃
class NormalBell implements Belling{

    @Override
    public void sound() {
        System.out.println("铃铃铃铃铃铃铃铃铃铃铃");
    }
}

//门铃，必须肯定有响声
interface Belling{
    //响铃
    void sound();
}