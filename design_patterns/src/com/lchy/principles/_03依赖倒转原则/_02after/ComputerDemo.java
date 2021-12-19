package com.lchy.principles._03依赖倒转原则._02after;

public class ComputerDemo {
    public static void main(String[] args) {
        //创建计算机的组件对象
        HardDisk hardDisk = new XiJieHardDisk();
        Cpu cpu = new IntelCPU();
        Memory memory = new KingstonMemory();

        //创建计算机对象
        Computer computer = new Computer();

        //组装计算机
        computer.setCpu(cpu);
        computer.setHardDisk(hardDisk);
        computer.setMemory(memory);

        //运行计算机
        computer.run();
    }
}
