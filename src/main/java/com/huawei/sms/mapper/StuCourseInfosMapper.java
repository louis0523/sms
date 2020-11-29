/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 */

package com.huawei.sms.mapper;

import com.huawei.sms.pojo.StuCourseInfos;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuCourseInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuCourseInfos record);

    int insertSelective(StuCourseInfos record);

    StuCourseInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuCourseInfos record);

    int updateByPrimaryKey(StuCourseInfos record);

    List<StuCourseInfos> queryStuCourseList(int id );

    List<StuCourseInfos> queryStuCourseByTeaId(Integer id);

    List<StuCourseInfos> queryStuCourseByStuId(int stuId);
}