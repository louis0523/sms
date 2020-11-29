/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.mapper;

import com.huawei.sms.pojo.StudentInfos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentInfosMapper {
    int deleteByPrimaryKey(String stuNo);

    int insert(StudentInfos record);

    int insertSelective(StudentInfos record);

    StudentInfos selectByPrimaryKey(String  stuNo);


    int updateByPrimaryKeySelective(StudentInfos record);

    int updateByPrimaryKey(StudentInfos record);

    StudentInfos selectById(int id);
    List<StudentInfos> getStuListByCoorId(int id);
}