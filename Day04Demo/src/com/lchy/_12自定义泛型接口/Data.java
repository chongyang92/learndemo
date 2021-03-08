package com.lchy._12自定义泛型接口;

//方法只能操作Student类型对象
/*public interface Data {
    *//*void add(Student student);
    void delete(Student student);
    void update(Student student);
    Student query(Student student);*//*
}*/
//泛型接口
public interface Data<E> {
    void add(E e);
    void delete(E e);
    void update(E e);
    E query(E e);
}