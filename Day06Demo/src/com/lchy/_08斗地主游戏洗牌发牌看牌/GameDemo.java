package com.lchy._08斗地主游戏洗牌发牌看牌;

import java.util.*;

/**
    目标：斗地主游戏的案例开发-Map集合实现。

    业务需求分析:
        斗地主的做牌，洗牌，发牌,排序（拓展知识）, 看牌
        业务:总共有54张牌。
        点数: "3","4","5","6","7","8","9","10","J","Q","K","A","2"
        花色: "♠", "♥", "♣", "♦"
        大小王: "👲" , "🃏"
        点数分别要组合4种花色，大小王各一张。
        斗地主：发出51张牌，剩下3张作为底牌。

    功能：
        1.做牌。
        2.洗牌
        3.定义3个玩家。
        4.发牌。
        5.
        6.看牌。

    用面向对象设计案例：
        a.定义一个牌类，代表牌对象。 一个牌对象代表一张牌。
        b.定义一个集合存储54张牌，集合只需要一个(因为牌只需要一副)
                {card1=0 , card2=1, ......}
 */
public class GameDemo {
    //a.定义一个map集合存储54张牌对象，键是牌对象，值是其大小
    private static final Map<Card, Integer> ALL_CARDS_SIZE = new HashMap<>();
    public static final List<Card> ALL_CARDS = new ArrayList<>();
    //b.做牌：静态代码块初始化54张牌对象
    static{
        //1.定义一个数组存储牌的点数，类型确定，个数确定请用数组存储！
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //2.定义一个数组存储牌的花色，类型确定，个数确定请用数组存储！
        String[] colors = {"♠", "♥", "♣", "♦"};

        //3.先遍历点数，再遍历花色
        int i = 0;
        for (String number : numbers) {
            for (String color : colors) {
                ALL_CARDS_SIZE.put(new Card(number,color),i++);
            }
        }
        ALL_CARDS_SIZE.put(new Card("","🃏"),i++);
        ALL_CARDS_SIZE.put(new Card("","👲"),i);
        System.out.println("新牌： " + ALL_CARDS_SIZE);

        ALL_CARDS.addAll(ALL_CARDS_SIZE.keySet());
    }

    public static void main(String[] args) {
        //c.洗牌
        Collections.shuffle(ALL_CARDS);
        System.out.println("洗牌： " + ALL_CARDS);


        //d.定义3个玩家
        List<Card> lingHuChong = new ArrayList<>();
        List<Card> jiuMoZhi = new ArrayList<>();
        List<Card> dongFangBuBai = new ArrayList<>();

        for (int i = 0; i < ALL_CARDS.size() - 3; i++) {
            if(i % 3 == 0){
                lingHuChong.add(ALL_CARDS.get(i));
            }else if(i % 3 == 1){
                jiuMoZhi.add(ALL_CARDS.get(i));
            }else{
                dongFangBuBai.add(ALL_CARDS.get(i));
            }
        }

        //e.给牌排序
        sortCard(lingHuChong);
        sortCard(jiuMoZhi);
        sortCard(dongFangBuBai);

        //f.看牌
        System.out.println(lingHuChong);
        System.out.println(jiuMoZhi);
        System.out.println(dongFangBuBai);

        //g.底牌
        List<Card> diPai = ALL_CARDS.subList(ALL_CARDS.size()-3,ALL_CARDS.size());
        System.out.println(diPai);
    }

    private static void sortCard(List<Card> cards) {
        cards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return ALL_CARDS_SIZE.get(o1) - ALL_CARDS_SIZE.get(o2);
            }
        });
    }

}
