package com.lchy._01单元测试;

import org.junit.*;

public class UserServiceTest {
    //资源初始化，可以获取文件内容到map中
    @Before
    public void before(){
        //UserService userService = new UserService();
        System.out.println("before");
    }

    //@After用来修饰实例方法，该方法会在每一个测试方法执行之后执行一次。
    @After
    public void after(){
        System.out.println("after");
    }

    //@BeforeClass用来修饰静态方法，该方法会在所有方法之前只执行一次。
    @BeforeClass
    public static void beforeClass(){
        System.out.println("=====beforeClass======");
    }

    //@AfterClass用来修饰静态方法，该方法会在所有方法之前只执行一次。
    @AfterClass
    public static void AfterClass(){
        System.out.println("=====AfterClass======");
    }

    /**
     * 测试方法的要求：
     *  1.必须public修饰
     *  2.没有返回值没有参数
     *  3.必须使用@Test注解
     */
    @Test
    public void testLogin(){
        UserService userService = new UserService();
        String rs = userService.login("admin","123456");
        //断言预期结果的正确性
        /**
         * 参数一：测试失败的提示信息
         * 参数二：期望值
         * 参数三：实际值
         */
        //public static void assertEquals(String message, Object expected, Objec
        Assert.assertEquals("登录业务功能方法有错误，请检查！",rs,"success");
    }

    @Test
    public void testChu(){
        UserService userService = new UserService();
        userService.chu(10,2);
    }
}
