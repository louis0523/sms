package com.huawei.sms.mapper;

import com.huawei.sms.pojo.StuCourseInfos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StucourseInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuCourseInfos record);

    int insertSelective(StuCourseInfos record);

    StuCourseInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuCourseInfos record);

    int updateByPrimaryKey(StuCourseInfos record);
}