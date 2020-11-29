package com.huawei.sms.service.impl;

import com.huawei.sms.mapper.*;
import com.huawei.sms.pojo.CourseInfos;
import com.huawei.sms.pojo.StuCourseInfos;
import com.huawei.sms.pojo.StudentInfos;
import com.huawei.sms.pojo.TeacherInfos;
import com.huawei.sms.pojo.bean.*;
import com.huawei.sms.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static com.huawei.sms.config.SmsEnums.*;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
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
    public BaseResult queryStuCourInfoById(Integer id) {
        //获取课程信息
        List<StuCourseInfos> stuCourseInfosList = stucourseInfosMapper.queryStuCourseByTeaId(id);
        Integer teaId = stuCourseInfosList.get(0).getTeaId();
        Integer courId = stuCourseInfosList.get(0).getCourId();
        CourseInfos courseInfos = courseInfosMapper.selectByPrimaryKey(courId);
        TeacherInfos teacherInfos = teacherInfosMapper.selectByPrimaryKey(teaId);

        List<BaseReStuNoSecretInfos> baseReStuNoSecretInfosList = new ArrayList<>();
        for (int i = 0; i <stuCourseInfosList.size() ; i++) {
            Integer stuId = stuCourseInfosList.get(i).getStuId();
            StudentInfos studentInfos = studentInfosMapper.selectById(stuId);
            BaseReStuNoSecretInfos baseReStuNoSecretInfos = new BaseReStuNoSecretInfos(studentInfos);
            baseReStuNoSecretInfosList.add(baseReStuNoSecretInfos);
        }
        BaseReStuCourseTeaInfos baseReStuCourseTeaInfos = new BaseReStuCourseTeaInfos(teacherInfos,courseInfos,baseReStuNoSecretInfosList);
        return new BaseResult(SERVER_SUCCESS, SERVER_SUCCESS_MSG, baseReStuCourseTeaInfos);
    }
}
