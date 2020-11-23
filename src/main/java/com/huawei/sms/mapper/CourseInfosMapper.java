package com.huawei.sms.mapper;

import com.huawei.sms.pojo.CourseInfos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseInfosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseInfos record);

    int insertSelective(CourseInfos record);

    CourseInfos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseInfos record);

    int updateByPrimaryKey(CourseInfos record);
}