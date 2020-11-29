package com.huawei.sms.controller;

import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.service.TeacherService;
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
@RequestMapping("/api/restful/teacher")
@Api(value = "/TeacherController", tags = "教师接口")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    /**
     * 任课老师可以查看该课程下的学生非敏感信息、课程信息及本人信息
     *
     * @param id 教师id
     * @return 任课老师可以查看该课程下的学生非敏感信息、课程信息及本人信息
     */
    @RequestMapping(value = "teacher/Query/StuCourseInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "教师查询学生和课程信息")
    public BaseResult teacherQueryStuCourseInfo(@PathVariable("id") int id) {
        LogUtil.Info("TeacherController" + "teacherQueryStuCourseInfo" + id);
        try {
            return teacherService.queryStuCourInfoById(id);
        } catch (Exception e) {
            LogUtil.Error("TeacherController",e);
        }
        return new BaseResult();
    }
}
