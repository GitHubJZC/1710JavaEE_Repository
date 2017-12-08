package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.test.mapper.StuMapper;
import com.test.po.Stu;

@Service
public class StuServiceImp implements StuService {
	@Autowired
	private StuMapper stuMapper;
	@Override
	public List<Stu> getAllStu() {
		List<Stu> list = stuMapper.selectStu();
		return list;
	}
	
	@Override
	public List<Stu> getStuByNowPage(int nowPage, int maxResult) {
		PageHelper.startPage(nowPage, maxResult);
		List<Stu> list = stuMapper.selectStu();
		return list;
	}
	
}
















