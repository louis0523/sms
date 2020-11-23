package com.huawei.sms.pojo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * teacherinfos
 * @author 
 */
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