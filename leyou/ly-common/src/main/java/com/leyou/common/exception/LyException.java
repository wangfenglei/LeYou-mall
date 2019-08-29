package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnum;


/**
 * @author wfl
 * @description
 */

public class LyException extends RuntimeException {

    private ExceptionEnum exceptionEnums;

    public LyException(ExceptionEnum exceptionEnums) {
        this.exceptionEnums = exceptionEnums;
    }

    public void setExceptionEnums(ExceptionEnum exceptionEnums) {
        this.exceptionEnums = exceptionEnums;
    }

    public ExceptionEnum getExceptionEnums() {
        return exceptionEnums;
    }
}
