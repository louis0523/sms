/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.controller;

import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.service.CoordinatorService;
import com.huawei.sms.utils.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.PUT,
        RequestMethod.OPTIONS, RequestMethod.TRACE
}, allowedHeaders = {"*"}, maxAge = 50000, origins = {"*"})
@RestController
@RequestMapping("/api/restful/Coordinator")
@Api(value = "/CoordinatorController", tags = "班主任接口")
public class CoordinatorController {
    @Resource
    private CoordinatorService coordinatorService;


    /**
     * 课程信息及班级任课老师信息
     *
     * @param id 班主任id
     * @return 课程信息及班级任课老师信息
     */
    @RequestMapping(value = "Course/Query/CourseInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "班主任查询信息")
    public BaseResult CourseInfo(@PathVariable("id") int id) {
        LogUtil.Info("CoordinatorController" + "CourseInfo" + id);
        try {
            return coordinatorService.getAllCourseTeaInfos(id);
        } catch (Exception e) {
            LogUtil.Error("CourseController",e);
        }
        return new BaseResult();
    }
}
