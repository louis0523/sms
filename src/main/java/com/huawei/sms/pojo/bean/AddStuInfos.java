package com.huawei.sms.pojo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class AddStuInfos implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 学生姓名
     */
    @NotEmpty(message = "学生姓名不能为空")
    private String stuName;

    /**
     * 学生性别 1 男  2 女
     */
    @NotNull(message = "性别不能为空")
    @Range(min = 1, max = 2, message = "男性：1，女性：2")
    private Integer stuSex;

    /**
     * 出生日期
     */
    @NotEmpty(message = "出生日期不能为空")
    private String birthday;

    /**
     * 年级
     */
    @NotEmpty(message = "年级不能为空")
    private String stuGrade;

    /**
     * 班级
     */
    @NotEmpty(message = "班级不能为空")
    private String stuClass;

    /**
     * 父名
     */
    @NotEmpty(message = "父名不能为空")
    private String faName;

    /**
     * 父号码
     */
    @NotEmpty(message = "父号码不能为空")
    private String faPhone;

    /**
     * 母名
     */
    @NotEmpty(message = "母名不能为空")
    private String moName;

    /**
     * 母号码
     */
    @NotEmpty(message = "母号码不能为空")
    private String moPhone;

    /**
     * 家庭住址
     */
    @NotEmpty(message = "家庭住址不能为空")
    private String address;

    /**
     * 学号
     */
    private String stuNo;

}
