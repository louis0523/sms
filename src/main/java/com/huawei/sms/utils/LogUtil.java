/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void Info(String message)
    {
        logger.info(message);
    }

    public static void Debug(String message)
    {
        logger.debug(message);
    }

    public static void Error(String message)
    {
        logger.error(message);
    }

    public static void Error(String message,Throwable t)
    {
        logger.error(message,t);
    }
}