/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.service;

import com.huawei.sms.pojo.bean.AddStuInfos;
import com.huawei.sms.pojo.bean.BaseResult;
import com.huawei.sms.pojo.bean.UpdateStuInfo;

public interface StudentService {

    BaseResult stuQueryInfos(String stuNo)throws Exception;
}
