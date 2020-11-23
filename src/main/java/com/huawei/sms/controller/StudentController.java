package com.huawei.sms.controller;

import com.huawei.sms.pojo.StudentInfos;
import com.huawei.sms.pojo.bean.AddStuInfos;
import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.pojo.bean.UpdateStuInfo;
import com.huawei.sms.service.StudentService;
import com.huawei.sms.utils.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@CrossOrigin(
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.HEAD,
                RequestMethod.PUT,
                RequestMethod.OPTIONS,
                RequestMethod.TRACE},
        allowedHeaders = {"*"},
        maxAge = 50000,
        origins = {"*"}
)
@RestController
@RequestMapping("/api/restful/student")
@Api(value = "/StudentController", tags = "学生接口")
public class StudentController {
    private static final String TAG_NAME = "[StudentController]:";

    @Resource
    private StudentService studentService;


    @RequestMapping(value = "/Add/StudentInfo", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加学生信息")
    public BaseResult AddStudentInfo(@Valid @RequestBody AddStuInfos addStuInfos) {
        LogUtil.Info(TAG_NAME+"AddStudentInfo"+addStuInfos.toString());
        return studentService.AddStudentInfo(addStuInfos);
    }


    @RequestMapping(value = "/Update/StudentInfo", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加学生信息")
    public BaseResult UpdateStudentInfo(@Valid @RequestBody UpdateStuInfo updateStuInfo) {
        LogUtil.Info(TAG_NAME+"UpdateStuInfo"+updateStuInfo.toString());
        return studentService.UpdateStudentInfo(updateStuInfo);
    }


}
