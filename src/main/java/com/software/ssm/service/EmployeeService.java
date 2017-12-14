package com.software.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.ssm.bean.Employee;
import com.software.ssm.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper empMapper;

	public List<Employee> getAllEmps() {
		return empMapper.selectByExampleWithDept(null);
	}

}
