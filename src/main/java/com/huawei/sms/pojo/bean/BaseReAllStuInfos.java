/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo.bean;

import com.huawei.sms.pojo.TeacherInfos;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@ApiModel(description = "接口实体")
public class BaseReAllStuInfos {
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
    private String teaSex;

    /**
     * 教师手机号码
     */
    private String teaPhone;

    /**
     * 职务
     */
    private String teaPosition;

    /**
     *  学生全部信息
     */
    List<BaseReStuInfos> baseReStuInfosList;


    public BaseReAllStuInfos(TeacherInfos teacherInfos,List<BaseReStuInfos> baseReStuInfosList) {
        this.id = teacherInfos.getId();
        this.teaName = teacherInfos.getTeaName();
        this.teaAge = teacherInfos.getTeaAge();
        this.birthday = teacherInfos.getBirthday();
        this.teaSex = teacherInfos.getTeaSex()==1?"男":"女";
        this.teaPhone = teacherInfos.getTeaPhone();
        this.teaPosition = teacherInfos.getTeaPosition()==1?"教师":"班主任";
        this.baseReStuInfosList = baseReStuInfosList;
    }
}
