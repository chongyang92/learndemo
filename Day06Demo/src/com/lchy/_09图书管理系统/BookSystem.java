package com.lchy._09图书管理系统;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
    目标：图书管理系统的开发

    业务需求分析：
        （1）查看全部书籍。query
        （2）添加书本信息。add
        （3）删除书本信息。delete
        （4）修改书本信息。update
        （5）退出系统。 exit

    书本信息的结构：
        类型                书名                 价格           作者
        -------------------------------------------------------------
        言情小说          《红楼梦》              28.9         曹雪芹
                         《还珠格格》             29.9         琼瑶
        武侠小说          《水浒传》              27.9          施耐庵
                         《天龙八部》             22.9          金庸
        神化小说          《西游记》               30.9         罗贯中
                         《封神榜》               25.9         许仲琳

    分析：
        （1）定义一个书本类
        （2）定义一个集合表示图书馆用于存储书本信息数据：Map<String,List<book>>
        （3）展示操作界面
        （4）完成相应功能
 */
public class BookSystem {

    /**
        1.定义一个集合表示图书馆用于存储书本信息数据：Map<String,List<book>>
        使用Map集合，键是橱柜的栏目类型名称，值是橱柜的List集合对象存储书本信息
     */
    public static final Map<String, List<Book>> BOOK_STORE = new HashMap<>();

    public static Scanner SYS_SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        //2.展示操作界面：独立功能建立封装成方法调用 方便互相之间的逻辑调用
        showCommand();
    }

    private static void showCommand() {
//        （1）查看全部书籍。query
//        （2）添加书本信息。add
//        （3）删除书本信息。delete
//        （4）修改书本信息。update
//        （5）退出系统。 exit
        System.out.println("----------欢迎进入系统------------");
        System.out.println("（1）查看全部书籍。query");
        System.out.println("（2）添加书本信息。add");
        System.out.println("（3）删除书本信息。delete");
        System.out.println("（4）修改书本信息。update");
        System.out.println("（5）退出系统。 exit");
        System.out.print("请输入操作命令：");
        String command = SYS_SCANNER.nextLine();
        //判断用户命令
        switch (command){
            case "1":
                if(BOOK_STORE.size() == 0) {
                    System.out.println("----------您的图书管没有书-----------");
                    break;
                }
                queryBooks();
                break;
            case "2":
                addBook();
                break;
            case "3":
                deleteBook();
                break;
            case "4":
                updateBook();
                break;
            case "5":
                System.out.println("退出成功");
                System.exit(0);
                break;
            default:
                System.err.println("命令输入有误");
        }
        showCommand();//方法递归，再调用自己
    }

    private static void deleteBook() {
        if(BOOK_STORE.size() == 0){
            System.out.println("您现在没有栏目可以删除");
            return;
        }
        queryBooks();
        System.out.println("========欢迎进入删除书本业务========");
        while (true){
            System.out.println("请输入删除书本的栏目：");
            String type = SYS_SCANNER.nextLine();
            //1.判断是否存在该栏目
            if(BOOK_STORE.containsKey(type)){
                while (true){
                    //存在该栏目
                    //2.请输入要删除的书名
                    System.out.println("请输入要删除的书名：");
                    String name = SYS_SCANNER.nextLine();
                    //3.判断该栏目下是否存在该书本对象
                    Book book = getBookByTypeAndName(type, name);
                    if(book == null){
                        System.out.println("书名不存在");
                    }else{
                        BOOK_STORE.get(type).remove(book);
                        queryBooks();
                        System.out.println("删除成功");
                        return;
                    }
                }
            }else {
                //不存在该栏目
                System.out.println("您输入的栏目不存在，请重新确认");
            }
        }
    }

    /**
        修改书本信息
     */
    private static void updateBook() {
        if(BOOK_STORE.size() == 0){
            System.out.println("您现在没有栏目可以改");
            return;
        }
        queryBooks();
        System.out.println("========欢迎进入修改书本业务========");
        while (true){
            System.out.println("请输入修改书本的栏目：");
            String type = SYS_SCANNER.nextLine();
            //1.判断是否存在该栏目
            if(BOOK_STORE.containsKey(type)){
                while (true){
                    //存在该栏目
                    //2.请输入要修改的书名
                    System.out.println("请输入要删除的书名：");
                    String name = SYS_SCANNER.nextLine();
                    //3.判断该栏目下是否存在该书本对象
                    Book book = getBookByTypeAndName(type, name);
                    if(book == null){
                        System.out.println("书名不存在,请重新输入书名：");
                    }else{
                        System.out.println("请输入书本新名称：");
                        String newname = SYS_SCANNER.nextLine();
                        System.out.println("请输入书本新价格：");
                        String newprice = SYS_SCANNER.nextLine();
                        System.out.println("请输入书本新作者：");
                        String newauthor = SYS_SCANNER.nextLine();

                        book.setName(newname);
                        book.setAuthor(newauthor);
                        book.setPrice(Double.parseDouble(newprice));
                        queryBooks();
                        System.out.println("修改成功");
                        return;
                    }
                }
            }else {
                //不存在该栏目
                System.out.println("您输入的栏目不存在，请重新确认");
            }
        }

    }

    /**
     * 在某个栏目下，根据书名查询这本书对象返回
     * @param type 栏目
     * @param name 书名
     * @return 书对象
     */
    public static Book getBookByTypeAndName(String type, String name){
        //1.先提取这个栏目的橱柜，根据栏目提取它的值
        List<Book> books = BOOK_STORE.get(type);
        for (Book book : books) {
            if(book.getName().equals(name)){
                return book;
            }
        }
        return null;
    }

    /**
        查询书本信息
     Map<String, List<Book>> BOOK_STORE = {type1 = [book1,book2] , type2=[...]}
     */
    private static void queryBooks() {
        System.out.println("类型\t\t\t\t书名\t\t\t\t价格\t\t\t\t作者");
        BOOK_STORE.forEach((type, books) -> {
            System.out.print(type);
            //遍历该类型下橱柜中的全部书本对象
            for (Book book : books) {
                System.out.println("\t\t\t\t"+book.getName()+"\t\t\t\t"+book.getPrice()+"\t\t\t\t"+book.getAuthor());
            }
        });
    }

    /**
       添加书本信息数据
     Map<String, List<Book>> BOOK_STORE = {type1 = [book1,book2] , type2=[...]}
     */
    private static void addBook() {
        System.out.println("----------欢迎进入添加书本业务------------");
        System.out.println("请输入添加书本的栏目：");
        String type = SYS_SCANNER.nextLine();

        List<Book> books = null;
        //1.判断是否存在该栏目
        if(BOOK_STORE.containsKey(type)){
            //3.存在该栏目
            //直接得到该栏目存在的出橱柜对象
            books = BOOK_STORE.get(type);
        }else {
            //2.该栏目是第一次添加
            books = new ArrayList<>();

            BOOK_STORE.put(type,books);
        }
        System.out.println("请输入书本名称：");
        String name = SYS_SCANNER.nextLine();
        System.out.println("请输入书本价格：");
        String price = SYS_SCANNER.nextLine();
        System.out.println("请输入书本作者：");
        String author = SYS_SCANNER.nextLine();
        Book book = new Book(name,Double.parseDouble(price),author);
        books.add(book);
    }



}
