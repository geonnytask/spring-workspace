package kr.co.jhta.dao;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.jhta.vo.Employee;

@Repository
public class EmployDao {
	
	private SqlMapClientTemplate template;
	
	public List<Employee> getAllEmployeesByDepartmentId() {
		return template.queryForList("getAllEmployeesByDepartmentId");
	}
	
	public List<Employee> getEmployeesById() {
		return template.queryForList("getEmployeesById");
	}
	
	public void addEmployees(Employee employee) {
		template.insert("addEmployees", employee);
	}

	
}
