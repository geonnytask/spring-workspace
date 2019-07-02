package kr.co.jhta.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import kr.co.jhta.vo.Customer;

public class CustomerDao {

	private SqlMapClientTemplate template;
	public void setTemplate(SqlMapClientTemplate template) {
		this.template = template;
	}
	public List<Customer> getAllCustomers() {
		return template.queryForList("getAllCustomers");
	}
	
	public Customer getCustomerByNo(int no) {
		return (Customer) template.queryForObject("getCustomerByNo", no);
	}
	
	public Customer getCustomerByKeyword(Map<String, Object> map) {
		return (Customer) template.queryForObject("getCustomerByKeyword", map);
	}
	
	public void updateCustomerByNo(int no) {
		template.queryForObject("updateCustomerByNo", no);
	}
}
