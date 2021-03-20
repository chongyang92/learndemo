package com.lchy._09自定义异常;

/**
    自定义编译时异常类：
        1.继承Exception
        2.重写构造器
 */
public class LchyAgelleagalRuntimeException extends RuntimeException {
    public LchyAgelleagalRuntimeException() {
    }

    //用这个
    public LchyAgelleagalRuntimeException(String message) {
        super(message);
    }

    public LchyAgelleagalRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LchyAgelleagalRuntimeException(Throwable cause) {
        super(cause);
    }

    public LchyAgelleagalRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
