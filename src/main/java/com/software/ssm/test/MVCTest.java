package com.software.ssm.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.software.ssm.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"classpath:applicationContext.xml", 
					 "file:src/main/webapp/WEB-INF/springDispatcherServlet-servlet.xml"
				})
public class MVCTest {
	
	private MockMvc mockmvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void init() {
		mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testMVC() throws Exception {
		MvcResult result = mockmvc.perform(MockMvcRequestBuilders.get("/emps").param("pageNo", "5")).andReturn();
		MockHttpServletRequest request = result.getRequest();
		PageInfo info = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码：" + info.getPageNum());
        System.out.println("总页码：" + info.getPages());
        System.out.println("总记录：" + info.getTotal());
        System.out.print("页面中需要连续显示的页码：");
        int[] nums = info.getNavigatepageNums();
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        List<Employee> emps = info.getList();
        for (Employee emp : emps  ) {
            System.out.println(emp.getEmpId() + ":" + emp.getEmpName() + ":" + emp.getDept().getDeptName());
        }
	}

}
