package com.lchy._07序列化;

import java.io.Serializable;
//
public class User implements Serializable{//NotSerializableException:如果不实现Serializable接口
    //加入序列版本号,文件中会有一个序列化编号，当从文件中识别的序列化编号和User中的不一致时，报InvalidClassException
    private static final long serialVersionUID = 2L;
    private String loginName;
    private String password;
    private String userName;

    public User() {
    }

    public User(String loginName, String password, String userName) {
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
