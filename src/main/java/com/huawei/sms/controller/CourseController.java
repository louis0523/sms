/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.controller;

import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.service.CourseService;
import com.huawei.sms.utils.LogUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin(methods = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.PUT,
    RequestMethod.OPTIONS, RequestMethod.TRACE
    }, allowedHeaders = {"*"}, maxAge = 50000, origins = {"*"})
@RestController
@RequestMapping("/api/restful/course")
@Api(value = "/CourseController", tags = "课程接口")
public class CourseController {
    @Resource
    private CourseService courseService;

    /**
     * 查看学生的课程列表
     *
     * @param id 学生id
     * @return 课程列表信息
     */
    @RequestMapping(value = "Course/Query/CourseInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "学生查询信息")
    public BaseResult studentQueryStudentInfo(@PathVariable("id") int id) {
        LogUtil.Info("CourseController" + "studentQueryStudentInfo" + id);
        try {
            return courseService.queryStuCourseInfos(id);
        } catch (Exception e) {
            LogUtil.Error("CourseController",e);
        }
        return new BaseResult();
    }
}
