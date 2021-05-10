package com.lchy._23字符集;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BigOrLittleEndian {

    public static void main(String[] args) {
        int a = 0x12345678;

        byte b = (byte)a;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toHexString(a));
        //ByteOrder byteOrder = new ByteOrder();

        int c = 0xff000000 & a;
        System.out.println(Integer.toHexString(c));

        //直接输出大小端结果
        System.out.println(ByteOrder.nativeOrder().toString());

    }

}
