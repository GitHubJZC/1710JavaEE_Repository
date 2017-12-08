package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.po.Stu;

public interface StuService {
	//得到所有学生
	public List<Stu> getAllStu();
	//分页查询学生
	public List<Stu> getStuByNowPage(int nowPage, int maxResult);
}
