/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo;

import com.huawei.sms.pojo.bean.AddStuInfos;
import com.huawei.sms.pojo.bean.UpdateStuInfo;
import com.huawei.sms.utils.DateUtils;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * studentinfos
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "接口实体")
public class StudentInfos implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 学号
     */
    private String stuNo;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生性别 1 男  2 女
     */
    private Integer stuSex;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 年龄
     */
    private Integer stuAge;

    /**
     * 年级
     */
    private String stuGrade;

    /**
     * 班级
     */
    private String stuClass;

    /**
     * 隐私id
     */
    private Integer stuSecret;

    /**
     * 班主任id
     */
    private Integer stuCooerId;

    private static final long serialVersionUID = 1L;

    public StudentInfos(AddStuInfos addStuInfos,String stuNo,Integer stuSecret) {
        this.stuNo = stuNo;
        this.stuName = addStuInfos.getStuName();
        this.stuSex = addStuInfos.getStuSex();
        this.birthday = DateUtils.strToDate(addStuInfos.getBirthday());
        this.stuAge = addStuInfos.getStuSex();
        this.stuGrade = addStuInfos.getStuGrade();
        this.stuClass = addStuInfos.getStuClass();
        this.stuSecret = stuSecret;
    }

    public StudentInfos(UpdateStuInfo updateStuInfo) {
        this.stuNo = updateStuInfo.getStuNo();
        this.stuName = updateStuInfo.getStuName();
        this.stuSex = updateStuInfo.getStuSex();
        this.birthday = DateUtils.strToDate(updateStuInfo.getBirthday());
        this.stuAge = updateStuInfo.getStuSex();
        this.stuGrade = updateStuInfo.getStuGrade();
        this.stuClass = updateStuInfo.getStuClass();
    }
}