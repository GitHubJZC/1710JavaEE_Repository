package com.test.ServiceTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.mapper.StuMapper;
import com.test.po.Stu;
import com.test.service.StuService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mapper.xml","classpath:spring/spring-service.xml" })
public class StuServiceTest {
	@Autowired
	private StuService stuService;
	@Test
	public void getAllStuTest() {
		List<Stu> list = stuService.getAllStu();
		for (Stu stu : list) {
			System.out.println(stu);
		}
	}
	@Test
	public void getStuByNowPageTest() {
		List<Stu> list = stuService.getStuByNowPage(2, 2);
		for (Stu stu : list) {
			System.out.println(stu);
		}
	}
}

