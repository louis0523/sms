package com.huawei.sms.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * stucourseinfos
 * @author 
 */
@Data
@ApiModel(description = "接口实体")
public class StuCourseInfos implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 学生id
     */
    private Integer stuId;

    /**
     * 教师id
     */
    private Integer teaId;

    /**
     * 课程id
     */
    private Integer courId;

    private static final long serialVersionUID = 1L;
}