/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static String SIMPLEDATEFORMAT = "yyyy-MM-dd";

    public static Date strToDate(String date) {
        if (StringUtils.isEmpty(date)){
            return new Date();
        }
        SimpleDateFormat format = new SimpleDateFormat(SIMPLEDATEFORMAT);
        Date date1 = null;
        try {
            date1 = format.parse(date);
        } catch (Exception e) {
            LogUtil.Error("日期转换",e);
        }
        return date1;
    }
}
