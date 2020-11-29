/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.service;

import com.huawei.sms.pojo.bean.BaseResult;

public interface CourseService {
    BaseResult queryStuCourseInfos(int id) throws Exception;
}
