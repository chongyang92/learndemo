package com.lchy._21递归的概述和应用理论;

/**
    目标：递归的经典案例

    猴子吃桃：
        猴子第一天摘了若干桃子，当即吃了一半，觉得好不过瘾，然后又多吃了一个。
        第二天又吃了前一天剩下的一半，觉得好不过瘾，然后又多吃了一个。
        以后每天都是如此
        等到第十天再吃的时候发现只有1个桃子，请问猴子第一天总共摘了多少个桃子。

    递归的三要素：
        （1）公式：第二天的桃子比前一天的桃子少一半又少一个
                f(n) = f(n-1) - f(n-1) / 2 - 1
                f(n) = f(n-1) / 2 - 1
                f(n+1) = f(n) / 2 - 1
                2f(n+1) = f(n) - 2
                f(n) = 2f(n+1) + 2
                f(10) = 1
        （2）终结点：
        （3）递归的方向：
 */
public class RecursionDemo04 {
    public static void main(String[] args) {
        System.out.println(f(2));
    }
    public static int f(int n){
        if(n == 10){
            return 1;
        }
        return 2*f(n + 1) + 2;
    }
}
