package kr.co.jhta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.dao.EmployDao;
import kr.co.jhta.vo.Employee;

@Controller
@RequestMapping("/emp2")
public class EmployeeController {
	
	@Autowired
	private EmployDao employDao;
	
	@RequestMapping("/depts.do")
	public String depts() {
		return "emp2/depts";
	}
	
	@RequestMapping("/form.do")
	public String form() {
		return "emp2/form";
	}
	
	@RequestMapping("/employees.do")
	public String employees() {
		return "emp2/employees";
	}
	
	@RequestMapping("/employee.do")
	public String employee() {
		return "emp2/employee";
	}
	
	@RequestMapping("/add.do")
	public String add(Employee employee) {
		
		employDao.addEmployees(employee);
		
		return "";
		
	}
	
}