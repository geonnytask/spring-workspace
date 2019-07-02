package kr.co.jhta.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.jhta.dao.CustomerDao;
import kr.co.jhta.vo.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		String resource = "classpath:/META-INF/spring/context.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);

		CustomerDao customerDao = ctx.getBean(CustomerDao.class);
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n");
			System.out.println("------------------------------------------------------");
			System.out.println("1.전체조회 2.검색 3.등록 4.수정 5.삭제 0.종료");
			System.out.println("------------------------------------------------------");
			
			System.out.print("메뉴선택> ");
			int menu = scanner.nextInt();
			
			if (menu == 1) {
				List<Customer> customer = customerDao.getAllCustomers();
				for(Customer cus : customer) {
					System.out.println("==========================");
					System.out.println("번호 : "+ cus.getNo());
					System.out.println("이름 : "+ cus.getName());
					System.out.println("전화번호 : "+ cus.getPhone());
				}
				
			 } else if (menu == 2) {
		            Map<String, Object> map = new HashMap<String, Object>();

		            System.out.print("검색하실 항목(번호/이름/닉네임) : ");
		            String search1 = scanner.next();
		            map.put("sort", search1);

		            System.out.print("검색하실 키워드를 입력하세요 : ");
		            if(search1.equals("번호")) {
		               int search2 = scanner.nextInt();
		               map.put("keyword", search2);
		            } else {
		               String search2 = scanner.next();
		               map.put("keyword", search2);
		            }
		            System.out.println();
		            Customer cus = customerDao.getCustomerByKeyword(map);

		            System.out.println("------검색 결과------");
		            System.out.println("번호 : "+cus.getNo());
		            System.out.println("이름 : "+cus.getName());
		            System.out.println("닉네임 : "+cus.getNickname());
		            System.out.println("전화번호 : "+cus.getPhone());
		            System.out.println("이메일 : "+cus.getEmail());
		            System.out.println("거주지 : "+cus.getCity());
		            System.out.println("적립포인트 : "+cus.getPoint());
		            System.out.println("등록일 : "+cus.getCreateDate());
		            
		         } else if (menu == 3) {
		            System.out.println("---------고객 추가--------");
		            System.out.print("이름 : ");
		            String name = scanner.next();
		            System.out.print("닉네임 : ");
		            String nickname = scanner.next();
		            System.out.print("전화번호 : ");
		            String phone = scanner.next();
		            System.out.print("이메일 : ");
		            String email = scanner.next();
		            System.out.print("거주지 : ");
		            String city = scanner.next();
		            System.out.print("적립포인트 : ");
		            int point = scanner.nextInt();
		            
		            Customer cus = new Customer();
		            cus.setName(name);
		            cus.setNickname(nickname);
		            cus.setPhone(phone);
		            cus.setEmail(email);
		            cus.setCity(city);
		            cus.setPoint(point);
		            
		            customerDao.insertCustomerByNo(cus);
		            
		         } else if (menu == 4) {
		            System.out.println("---------고객 변경--------");
		            System.out.print("변경할 고객 번호 입력 : ");
		            int no = scanner.nextInt();
		            
		            Customer cus = customerDao.getCustomerByNo(no);
		            if(cus == null) {
		               System.out.println("검색된 고객이 없습니다.");
		               return;
		            }
		            System.out.println("변경될 정보=============");
		            System.out.print("이름 : ");
		            String name = scanner.next();
		            System.out.print("닉네임 : ");
		            String nickname = scanner.next();
		            System.out.print("전화번호 : ");
		            String phone = scanner.next();
		            System.out.print("이메일 : ");
		            String email = scanner.next();
		            System.out.print("거주지 : ");
		            String city = scanner.next();
		            System.out.print("적립포인트 : ");
		            int point = scanner.nextInt();
		            
		            cus.setName(name);
		            cus.setNickname(nickname);
		            cus.setPhone(phone);
		            cus.setEmail(email);
		            cus.setCity(city);
		            cus.setPoint(point);
		            
		            customerDao.updateCustomerByNo(no);
		            
		         } else if (menu == 5) {
		            System.out.println("---------고객 삭제--------");
		            System.out.print("삭제할 고객 번호 입력 : ");
		            int no = scanner.nextInt();
		            
		            customerDao.deleteCustomerByNo(no);
		            
		         } else if (menu == 0) {
		            System.out.println("프로그램을 종료합니다.");
		            break;
		         }
		         
		      }
		      
		   }
		}
