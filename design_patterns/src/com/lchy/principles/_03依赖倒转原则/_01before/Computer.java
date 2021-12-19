package com.lchy.principles._03依赖倒转原则._01before;

public class Computer {
    private XiJieHardDisk hardDisk;
    private IntelCPU cpu;
    private KingstonMemory kingstonMemory;

    public XiJieHardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(XiJieHardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public IntelCPU getCpu() {
        return cpu;
    }

    public void setCpu(IntelCPU cpu) {
        this.cpu = cpu;
    }

    public KingstonMemory getKingstonMemory() {
        return kingstonMemory;
    }

    public void setKingstonMemory(KingstonMemory kingstonMemory) {
        this.kingstonMemory = kingstonMemory;
    }
    public void run(){
        System.out.println("运行计算机");
        String data = hardDisk.get();
        System.out.println("从硬盘上获取的数据:"+data);
        cpu.run();
        kingstonMemory.save();
    }
}
