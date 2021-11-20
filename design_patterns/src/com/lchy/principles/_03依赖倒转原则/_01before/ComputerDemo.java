package com.lchy.principles._03依赖倒转原则._01before;

public class ComputerDemo {
    public static void main(String[] args) {
        //创建组件对象
        XiJieHardDisk xiJieHardDisk = new XiJieHardDisk();
        IntelCPU intelCPU = new IntelCPU();
        KingstonMemory kingstonMemory = new KingstonMemory();
        //创建计算机对象
        Computer computer = new Computer();
        //组装计算机
        computer.setCpu(intelCPU);
        computer.setHardDisk(xiJieHardDisk);
        computer.setKingstonMemory(kingstonMemory);

        //运行计算机
        computer.run();
    }
}
