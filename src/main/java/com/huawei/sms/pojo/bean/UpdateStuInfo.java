package com.huawei.sms.pojo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UpdateStuInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 学号
     */
    @NotEmpty(message = "学号不能为空")
    private String stuNo;
    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生性别 1 男  2 女
     */
    @Range(min = 1, max = 2, message = "男性：1，女性：2")
    private Integer stuSex;

    /**
     * 出生日期
     */
    @Pattern(regexp = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$",message = "不符合yyyy-MM-dd HH:mm:ss")
    private String birthday;

    /**
     * 年级
     */
    private String stuGrade;

    /**
     * 班级
     */
    private String stuClass;

    /**
     * 父名
     */
    private String faName;

    /**
     * 父号码
     */
    private String faPhone;

    /**
     * 母名
     */
    private String moName;

    /**
     * 母号码
     */
    private String moPhone;

    /**
     * 家庭住址
     */
    private String address;

}