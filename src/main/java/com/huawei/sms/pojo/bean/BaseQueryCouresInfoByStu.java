/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo.bean;

import com.huawei.sms.pojo.CourseInfos;
import com.huawei.sms.pojo.TeacherInfos;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@ApiModel(description = "接口实体")
public class BaseQueryCouresInfoByStu {
    /**
     * 教师id
     */
    private Integer teaId;

    /**
     * 教师姓名
     */
    private String teaName;
    /**
     * 主键id
     */
    private Integer coureseId;

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

    public BaseQueryCouresInfoByStu(TeacherInfos teacherInfos, CourseInfos courseInfos) {
        this.teaId = teacherInfos.getId();
        this.teaName = teacherInfos.getTeaName();
        this.coureseId = courseInfos.getId();
        this.courseName = courseInfos.getCourseName();
        this.courseTime = courseInfos.getCourseTime();
        this.coursePeriod = courseInfos.getCoursePeriod();
    }
}
