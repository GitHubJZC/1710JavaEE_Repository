package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.po.Stu;

public interface StuMapper {
	List<Stu>  selectStu();
}
