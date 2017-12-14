package com.software.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.software.ssm.bean.Employee;
import com.software.ssm.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	private EmployeeMapper empMapper;
	
	@Test
	public void testSelect2() {
		Employee emp = empMapper.selectByPrimaryKeyWithDept(888);
		System.out.println(emp.getEmpName() + "--->" + emp.getEmail() + "--->" + emp.getDept().getDeptName());
	}

	@Test
	public void testSelect() {
		List<Employee> emps = empMapper.selectByExampleWithDept(null);
		for (Employee emp : emps) {
			System.out.println(emp.getEmpName() + "--->" + emp.getDept().getDeptName());
		}
	}

}
