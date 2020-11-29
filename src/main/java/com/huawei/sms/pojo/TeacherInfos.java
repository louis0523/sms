/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(description = "接口实体")
public class TeacherInfos implements Serializable {
    /**
     * 教师id
     */
    private Integer id;

    /**
     * 教师姓名
     */
    private String teaName;

    /**
     * 教师年龄
     */
    private Integer teaAge;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 教师性别
     */
    private Integer teaSex;

    /**
     * 教师手机号码
     */
    private String teaPhone;

    /**
     * 职务
     */
    private Integer teaPosition;

    private static final long serialVersionUID = 1L;
}