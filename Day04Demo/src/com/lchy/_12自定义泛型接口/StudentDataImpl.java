package com.lchy._12自定义泛型接口;

import java.util.ArrayList;

/**
        这里在实现接口时，实现类可以扩展接口泛型变量的个数
        public class ClassDataImpl<E,T> implements InterfaceData<E>
 */

//public class StudentDataImpl<Student,Teacher> implements Data<Student>{
    //

public class StudentDataImpl implements Data<Student> {
    @Override
    public void add(Student student) {
        System.out.println("添加学生");
    }

    @Override
    public void delete(Student student) {
        System.out.println("删除学生");
    }

    @Override
    public void update(Student student) {
        System.out.println("更新学生");
    }

    @Override
    public Student query(Student student) {
        return null;
    }
}
//接口继承时，可以不写泛型
interface MyData extends Data{

}
interface MyData1<Student> extends Data<Teacher>{

}
class MyDataClass<Student> implements MyData1<Teacher>{

    @Override
    public void add(Teacher teacher) {

    }

    @Override
    public void delete(Teacher teacher) {

    }

    @Override
    public void update(Teacher teacher) {

    }

    @Override
    public Teacher query(Teacher teacher) {
        return null;
    }
}