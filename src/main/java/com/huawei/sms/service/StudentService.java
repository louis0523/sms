package com.huawei.sms.service;

import com.huawei.sms.pojo.StudentInfos;
import com.huawei.sms.pojo.bean.AddStuInfos;
import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.pojo.bean.UpdateStuInfo;

public interface StudentService {
    BaseResult AddStudentInfo(AddStuInfos addStuInfos);

    BaseResult UpdateStudentInfo(UpdateStuInfo updateStuInfo);
}
