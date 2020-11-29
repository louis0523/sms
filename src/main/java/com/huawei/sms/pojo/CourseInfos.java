/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "接口实体")
public class CourseInfos implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 课名
     */
    private String courseName;

    /**
     * 标准学时
     */
    private Double courseTime;

    /**
     * 标准课时
     */
    private Double coursePeriod;

    private static final long serialVersionUID = 1L;
}