package com.huawei.sms.service.impl;

import cn.hutool.core.util.IdUtil;
import com.huawei.sms.mapper.SecretInfosMapper;
import com.huawei.sms.mapper.StudentInfosMapper;
import com.huawei.sms.pojo.SecretInfos;
import com.huawei.sms.pojo.StudentInfos;
import com.huawei.sms.pojo.bean.AddStuInfos;
import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.pojo.bean.UpdateStuInfo;
import com.huawei.sms.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.huawei.sms.config.SmsEnums.*;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentInfosMapper studentInfosMapper;
    @Resource
    private SecretInfosMapper secretInfosMapper;


    @Transactional
    @Override
    public BaseResult AddStudentInfo(AddStuInfos addStuInfos) {
        BaseResult result = null;
        String stuNo = IdUtil.simpleUUID();
        SecretInfos secretInfos = new SecretInfos(addStuInfos,stuNo);
        int insertNum = secretInfosMapper.insert(secretInfos);
        if (insertNum>0){
            StudentInfos studentInfos = new StudentInfos(addStuInfos,stuNo,secretInfos.getId());
            insertNum = studentInfosMapper.insert(studentInfos);
            if (insertNum>0){
                result = new BaseResult(SERVER_SUCCESS,SERVER_SUCCESS_MSG,"");
            }else {
                result = new BaseResult(SERVER_REGISTER_ERROR,SERVER_REGISTER_STUDENT_ERROR_MSG,"");
            }
        }else {
            result = new BaseResult(SERVER_REGISTER_ERROR,SERVER_REGISTER_PARENT_ERROR_MSG,"");
        }
        return result = new BaseResult(SERVER_ERROR,SERVER_ERROR_MSG,"");
    }

    @Override
    public BaseResult  UpdateStudentInfo(UpdateStuInfo updateStuInfo) {
        return null;
    }


}
