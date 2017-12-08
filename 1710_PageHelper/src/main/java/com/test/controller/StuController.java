package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.test.po.Stu;
import com.test.publicData.PublicData;
import com.test.service.StuService;

@Controller
public class StuController {
	
	@Autowired
	private StuService stuService;
	
	//转发到stu
	@RequestMapping(value="forwardToStuJsp.do")
	public String forwardToStuJsp(HttpServletRequest req) {
		return "stu";
	}
	//转发到stu
		@RequestMapping(value="forwardToStu2Jsp.do")
		public String forwardToStu2Jsp(HttpServletRequest req) {
			return "stu2";
		}
	
	//得到总页数
	@ResponseBody
	@RequestMapping(value="getTotalPage.do")
	public String getTotalPage() {
		List<Stu> list = stuService.getStuByNowPage(2, PublicData.MAX_RESULT);
		PageInfo pageInfo=new PageInfo(list);
		return pageInfo.getPages()+"";
	}
	
	//分页显示Stu
	@ResponseBody
	@RequestMapping(value="getStuByNowPage.do")
	public List<Stu> getStuByNowPage(int nowPage){
		List<Stu> list =stuService.getStuByNowPage(nowPage, PublicData.MAX_RESULT);
		return list;
	}
	
	
	//把得到总页数和分页显示Stu合并在一起
	@ResponseBody
	@RequestMapping(value="xxx.do")
	public Map<String,Object> xxx(int nowPage){
		List<Stu> list= stuService.getStuByNowPage(nowPage, PublicData.MAX_RESULT);
		PageInfo  pageInfo = new PageInfo(list); 
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pageInf",pageInfo );
		map.put("list", list);
		return map;
		
	}
	
}

////用PageInfo对结果进行包装
//PageInfo page = new PageInfo(list);
////PageInfo包含了非常全面的分页属性
//System.out.println(page.getPageNum());//当前页
//System.out.println(page.getPageSize());//每页最大条数
//System.out.println(page.getStartRow());//
//System.out.println(page.getEndRow());
//System.out.println(page.getTotal());//总条数 54
//System.out.println(page.getPages());//总页数
//System.out.println(page.getFirstPage());
//System.out.println(page.getLastPage());
//System.out.println(page.isIsFirstPage());
//System.out.println(page.isIsLastPage());
//System.out.println(page.isHasPreviousPage());
//System.out.println(page.isHasNextPage());






