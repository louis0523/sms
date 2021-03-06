/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.pojo.bean;

import com.huawei.sms.pojo.StudentInfos;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@ApiModel(description = "接口实体")
public class BaseQueryStuInfos {
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
    private String stuSex;

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


    public BaseQueryStuInfos(StudentInfos studentInfos) {
        this.id = studentInfos.getId();
        this.stuNo = studentInfos.getStuNo();
        this.stuName = studentInfos.getStuName();
        this.stuSex = studentInfos.getStuSex() == 1 ? "男" : "女";
        this.birthday = studentInfos.getBirthday();
        this.stuAge = studentInfos.getStuAge();
        this.stuGrade = studentInfos.getStuGrade() + "年纪";
        this.stuClass = studentInfos.getStuClass() + "班";
    }

    public List<BaseQueryStuInfos> getInfoList(List<StudentInfos> list) {
        List<BaseQueryStuInfos> infosList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            BaseQueryStuInfos baseQueryStuInfos = new BaseQueryStuInfos(list.get(i));
            infosList.add(baseQueryStuInfos);
        }
        return infosList;

    }
}
