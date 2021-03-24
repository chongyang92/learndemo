package com.lchy._21递归的概述和应用理论;

/**
    目标：1~n的和。1到n的和
        f(n) = 1 + 2 + 3 + 4 + 5 + 6 + ... n-1 + n;
        f(n) = f(n-1) + n;
    流程：
        f(5) = f(4) + 5 = 1 + 2 + 3 + 4 + 5
        f(4) = f(3) + 4 = 1 + 2 + 3 + 4
        f(3) = f(2) + 3 = 1 + 2 + 3
        f(2) = f(1) + 2 = 1 + 2
        f(1) = 1
    递归算法的三要素：
        (1)递归的公式 f(n) = f(n-1) + n
        (2)递归的终结点:f(1) = 1
        (3)递归的方向：必须走向终结点。

 */
public class RecursionDemo05 {
    public static void main(String[] args) {
        System.out.println(f(10));
    }

    public static int f(int n){
        if(n == 1){
            return 1;
        }
        return f(n-1) + n;
    }
}
