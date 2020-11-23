package com.huawei.sms.pojo;

import java.io.Serializable;
import java.util.Date;

import com.huawei.sms.pojo.bean.AddStuInfos;
import com.huawei.sms.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * studentinfos
 * @author 
 */
@Data
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

    private static final long serialVersionUID = 1L;

    public StudentInfos(Integer id, String stuNo, String stuName, Integer stuSex, Date birthday, Integer stuAge, String stuGrade, String stuClass, Integer stuSecret) {
        this.id = id;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.birthday = birthday;
        this.stuAge = stuAge;
        this.stuGrade = stuGrade;
        this.stuClass = stuClass;
        this.stuSecret = stuSecret;
    }
    public StudentInfos() {
    }
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
}