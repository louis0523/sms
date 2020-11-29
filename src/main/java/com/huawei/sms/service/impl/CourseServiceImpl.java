/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.service.impl;

import static com.huawei.sms.config.SmsEnums.*;

import com.huawei.sms.mapper.CourseInfosMapper;
import com.huawei.sms.mapper.StuCourseInfosMapper;
import com.huawei.sms.mapper.StudentInfosMapper;
import com.huawei.sms.mapper.TeacherInfosMapper;
import com.huawei.sms.pojo.CourseInfos;
import com.huawei.sms.pojo.StuCourseInfos;
import com.huawei.sms.pojo.StudentInfos;
import com.huawei.sms.pojo.TeacherInfos;
import com.huawei.sms.pojo.bean.BaseQueryCouresInfoByStu;
import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.pojo.bean.QueryReCourInfos;
import com.huawei.sms.service.CourseService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseInfosMapper courseInfosMapper;

    @Resource
    private TeacherInfosMapper teacherInfosMapper;

    @Resource
    private StuCourseInfosMapper stucourseInfosMapper;

    @Resource
    private StudentInfosMapper studentInfosMapper;

    @Override
    public BaseResult queryStuCourseInfos(int id) throws Exception {
        List<BaseQueryCouresInfoByStu> baseQueryCouresInfoByStus = new ArrayList<>();
        List<StuCourseInfos> stuCourseInfos = stucourseInfosMapper.queryStuCourseList(id);

        StudentInfos studentInfos = studentInfosMapper.selectById(id);
        QueryReCourInfos queryReCourInfos = new QueryReCourInfos();
        queryReCourInfos.setId(id);
        queryReCourInfos.setStuName(studentInfos.getStuName());
        queryReCourInfos.setStuGrade(studentInfos.getStuGrade());
        queryReCourInfos.setStuClass(studentInfos.getStuClass());
        if (stuCourseInfos == null) {
            return new BaseResult(SERVER_SUCCESS, SERVER_SUCCESS_MSG, queryReCourInfos);
        }
        for (int i = 0; i < stuCourseInfos.size(); i++) {
            CourseInfos courseInfos = courseInfosMapper.selectByPrimaryKey(stuCourseInfos.get(i).getCourId());
            TeacherInfos teacherInfos = teacherInfosMapper.selectByPrimaryKey(stuCourseInfos.get(i).getTeaId());
            BaseQueryCouresInfoByStu baseQueryCouresInfoByStu = new BaseQueryCouresInfoByStu(teacherInfos, courseInfos);
            baseQueryCouresInfoByStus.add(baseQueryCouresInfoByStu);
        }
        queryReCourInfos.setBaseQueryCouresInfoByStus(baseQueryCouresInfoByStus);
        return new BaseResult(SERVER_SUCCESS, SERVER_SUCCESS_MSG, queryReCourInfos);
    }
}
