/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.config;

import static com.huawei.sms.config.SmsEnums.PARAMETER_ERROR;

import com.huawei.sms.pojo.bean.BaseResult;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResult MyExceptionHandle(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> {
                errorMsg.append(error.getDefaultMessage()).append(";");
            });

        }
        return new BaseResult(PARAMETER_ERROR, errorMsg.toString(), "");
    }
}
