/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.service.impl;

import static com.huawei.sms.config.SmsEnums.MAC_NUM_0;
import static com.huawei.sms.config.SmsEnums.SERVER_DELETE_STUDENT_ERROR_MSG;
import static com.huawei.sms.config.SmsEnums.SERVER_REGISTER_ERROR;
import static com.huawei.sms.config.SmsEnums.SERVER_REGISTER_PARENT_ERROR_MSG;
import static com.huawei.sms.config.SmsEnums.SERVER_REGISTER_STUDENT_ERROR_MSG;
import static com.huawei.sms.config.SmsEnums.SERVER_SUCCESS;
import static com.huawei.sms.config.SmsEnums.SERVER_SUCCESS_MSG;
import static com.huawei.sms.config.SmsEnums.SERVER_UPDATE_PARENT_ERROR_MSG;
import static com.huawei.sms.config.SmsEnums.SERVER_UPDATE_STUDENT_ERROR_MSG;
import static com.huawei.sms.config.SmsEnums.STUDENT_IS_NOT_EXIST;

import com.huawei.sms.mapper.*;
import com.huawei.sms.pojo.*;
import com.huawei.sms.pojo.bean.*;
import com.huawei.sms.service.StudentService;

import cn.hutool.core.util.IdUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private TeacherInfosMapper teacherInfosMapper;
    @Resource
    private CourseInfosMapper courseInfosMapper;
    @Resource
    private StudentInfosMapper studentInfosMapper;
    @Resource
    private StuCourseInfosMapper stucourseInfosMapper;
    @Resource
    private SecretInfosMapper secretInfosMapper;

    @Override
    public BaseResult stuQueryInfos(String stuNo) throws Exception {
        StudentInfos studentInfos = studentInfosMapper.selectByPrimaryKey(stuNo);
        SecretInfos secretInfos = secretInfosMapper.selectByPrimaryKey(stuNo);
        List<StuCourseInfos> stuCourseInfosList = stucourseInfosMapper.queryStuCourseByStuId(studentInfos.getId());
        // 获取教师id 课程id
        List<BaseReTeaCourseInfos> baseReTeaCourseInfosList = new ArrayList<>();
        for (int j = 0; j < stuCourseInfosList.size(); j++) {
            StuCourseInfos stuCourseInfos = stuCourseInfosList.get(j);
            Integer courId = stuCourseInfos.getCourId();
            Integer teaId = stuCourseInfos.getTeaId();
            TeacherInfos teacherInfos = teacherInfosMapper.selectByPrimaryKey(teaId);
            CourseInfos courseInfos = courseInfosMapper.selectByPrimaryKey(courId);
            BaseReTeaCourseInfos baseReTeaCourseInfos =new BaseReTeaCourseInfos(teacherInfos,courseInfos);
            // 组装数据
            baseReTeaCourseInfosList.add(baseReTeaCourseInfos);
        }
        BaseReStuInfo baseReStuInfo = new BaseReStuInfo(studentInfos,secretInfos,baseReTeaCourseInfosList);
        return new BaseResult(SERVER_SUCCESS, SERVER_SUCCESS_MSG, baseReStuInfo);
    }

}
