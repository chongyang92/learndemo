package com.lchy._09自定义异常;

/**
    自定义编译时异常类：
        1.继承Exception
        2.重写构造器
 */
public class LchyAgelleagalException extends Exception {
    public LchyAgelleagalException() {
    }

    //用这个
    public LchyAgelleagalException(String message) {
        super(message);
    }

    public LchyAgelleagalException(String message, Throwable cause) {
        super(message, cause);
    }

    public LchyAgelleagalException(Throwable cause) {
        super(cause);
    }

    public LchyAgelleagalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
