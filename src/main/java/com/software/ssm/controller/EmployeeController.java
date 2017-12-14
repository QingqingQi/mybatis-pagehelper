package com.software.ssm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.software.ssm.bean.Employee;
import com.software.ssm.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@SuppressWarnings("all")
	@RequestMapping("/emps")
	public String getAllEmps(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, Map<String, Object> map) {
		PageHelper.startPage(pageNo, 5);
		List<Employee> emps = empService.getAllEmps();
		PageInfo pageInfo = new PageInfo(emps, 5);
		map.put("pageInfo", pageInfo);
		return "list";
	}

}
