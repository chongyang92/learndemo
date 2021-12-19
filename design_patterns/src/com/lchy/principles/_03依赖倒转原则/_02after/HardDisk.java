package com.lchy.principles._03依赖倒转原则._02after;

public interface HardDisk {
    //存储数据
    void save(String data);

    //获取数据
    String get();
}
