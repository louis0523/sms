/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.controller;

import com.huawei.sms.pojo.bean.AddStuInfos;
import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.pojo.bean.UpdateStuInfo;
import com.huawei.sms.service.StudentService;
import com.huawei.sms.utils.LogUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@CrossOrigin(methods = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.PUT,
    RequestMethod.OPTIONS, RequestMethod.TRACE
    }, allowedHeaders = {"*"}, maxAge = 50000, origins = {"*"})
@RestController
@RequestMapping("/api/restful/student")
@Api(value = "/StudentController", tags = "学生接口")
public class StudentController {
    private static final String TAG_NAME = "[StudentController]:";

    @Resource
    private StudentService studentService;

    /**
     * 学生只拥有查询课程及本人信息；
     *
     * @param stuNo 学号
     * @return 学生只拥有查询课程及本人信息
     */
    @RequestMapping(value = "Student/Query/StudentInfo/{stuNo}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "学生查询信息")
    public BaseResult studentQueryStudentInfo(@PathVariable("stuNo") String stuNo) {
        LogUtil.Info(TAG_NAME + "studentQueryStudentInfo" + stuNo.toString());
        try {
            return studentService.stuQueryInfos(stuNo);
        } catch (Exception e) {
            LogUtil.Error(TAG_NAME, e);
        }
        return new BaseResult();
    }



}
