/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@ApiModel(description = "接口实体")
public class QueryReCourInfos {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 年级
     */
    private String stuGrade;

    /**
     * 班级
     */
    private String stuClass;
    /**
     * 课程列表
     */
    private List<BaseQueryCouresInfoByStu> baseQueryCouresInfoByStus;


}
