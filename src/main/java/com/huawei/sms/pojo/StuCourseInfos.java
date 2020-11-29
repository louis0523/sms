/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * stucourseinfos
 * @author 
 */
@Data
@ApiModel(description = "接口实体")
public class StuCourseInfos implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 学生id
     */
    private Integer stuId;

    /**
     * 教师id
     */
    private Integer teaId;

    /**
     * 课程id
     */
    private Integer courId;

    private static final long serialVersionUID = 1L;
}