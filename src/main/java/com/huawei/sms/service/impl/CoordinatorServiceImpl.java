/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.service.impl;

import com.huawei.sms.mapper.*;
import com.huawei.sms.pojo.*;
import com.huawei.sms.pojo.bean.*;
import com.huawei.sms.service.CoordinatorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.huawei.sms.config.SmsEnums.SERVER_SUCCESS;
import static com.huawei.sms.config.SmsEnums.SERVER_SUCCESS_MSG;

@Service("coordinatorService")
public class CoordinatorServiceImpl implements CoordinatorService {
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
    public BaseResult getAllCourseTeaInfos(Integer id) {
        // 获取班主任信息
        TeacherInfos coordinatorInfo = teacherInfosMapper.selectByPrimaryKey(id);

        // 获取班级信息
        List<StudentInfos> stuListByCoorIdList = studentInfosMapper.getStuListByCoorId(id);

        //
        List<BaseReStuInfo> baseReStuInfoList = new ArrayList<>();
        for (int i = 0; i < stuListByCoorIdList.size(); i++) {
            StudentInfos studentInfos = stuListByCoorIdList.get(i);
            String stuNo = studentInfos.getStuNo();
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
            baseReStuInfoList.add(baseReStuInfo);
        }
        BaseAllStuInfos baseReAllStuInfos = new BaseAllStuInfos(coordinatorInfo,baseReStuInfoList);
        return new BaseResult(SERVER_SUCCESS, SERVER_SUCCESS_MSG, baseReAllStuInfos);
    }
}
