/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo.bean;

import com.huawei.sms.pojo.CourseInfos;
import com.huawei.sms.pojo.StudentInfos;
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
public class BaseReCourseInfo {
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

    /**
     * 学生信息列表
     */
    private List<BaseQueryStuInfos> stuList;

    public BaseReCourseInfo(CourseInfos courseInfos,List<StudentInfos> list) {
        this.id = courseInfos.getId();
        this.courseName = courseInfos.getCourseName();
        this.courseTime = courseInfos.getCourseTime();
        this.coursePeriod = courseInfos.getCoursePeriod();
        this.stuList = new BaseQueryStuInfos().getInfoList(list);
    }
}
