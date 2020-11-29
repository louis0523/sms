/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.mapper;

import com.huawei.sms.pojo.TeacherInfos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherInfos record);

    int insertSelective(TeacherInfos record);

    TeacherInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherInfos record);

    int updateByPrimaryKey(TeacherInfos record);
}