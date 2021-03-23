package com.lchy._06方法引用方式一_静态方法的引用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
     目标：方法引用有四种形式：
         1.静态方法的引用。
         2.实例方法的引用。
         3.特定类型方法的引用。
         4.构造器引用。

     1.静态方法的引用。
         引用格式：
         类名::静态方法。
         简化步骤：
            a.定义一个静态方法，把需要简化的代码放到一个静态方法中去。
            静态方法引用的注意事项
            ” 重要：被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致。“
     小结：
        静态方法引用的格式： 类名::静态方法。
     重要：被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致,才可以引用简化！
 */
public class MethodDemo01 {
    public static void main(String[] args) {
        List<Orange> oranges = new ArrayList<>();
        Orange o1 = new Orange("红橘子",654.0 ,"贼便宜~");
        Orange o2 = new Orange("黄橘子",454.0 ,"贼便宜~");
        Orange o3 = new Orange("黄橘子",454.0 ,"贼便宜~");
        Orange o4 = new Orange("青橘子",456.0 ,"贼便宜~");
        Collections.addAll(oranges,o1,o2,o3,o4);
        /**匿名内部类写法**/
        Collections.sort(oranges, new Comparator<Orange>() {
            @Override
            public int compare(Orange o1, Orange o2) {
                return Double.compare(o1.getWeight() , o2.getWeight());
            }
        });
        /**Lambda表达式写法,接口名称省略**/
        Collections.sort(oranges, (Orange orange1, Orange orange2) ->{
            return Double.compare(orange1.getWeight() , orange2.getWeight());
        });

        /**Lambda表达式省略写法一：类型可以省略**/
        Collections.sort(oranges, (orange1, orange2) ->{
            return Double.compare(orange1.getWeight() , orange2.getWeight());
        });
        /**Lambda表达式省略写法一：只有一行，{}可以省略，如果有返回语句，必须省略return不写**/
        Collections.sort(oranges, Comparator.comparingDouble(Orange::getWeight));
        //使用静态方法进行比较
        Collections.sort(oranges, (orange1, orange2) -> Orange.compareByWeight(orange1,orange2));
        //方法引用，接口中和我自定义的方法，有同样的参数列表时,可以简写为类名::静态方法名
        //可以理解为，我已经实现了一个静态方法，就是函数式接口中的方法的具体实现(方法名可以不同，参数类型和返回值)，直接通过::引用即可
        Collections.sort(oranges, Orange::compareByWeight);
        FutureTask futureTask = new FutureTask(Orange::acall);
    }
}
