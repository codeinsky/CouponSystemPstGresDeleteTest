package couponSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import couponSystem.beans.Coupon;
import couponSystem.repos.CompanyRepo;
import couponSystem.repos.CouponsRepo;
import couponSystem.repos.CustomerRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponPstGresLocalApplicationTests {
	
	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	CouponsRepo couponRepo;
	
	@Autowired
	CustomerRepo customerRepo; 

	@Test
	public void contextLoads() {
	}
	
//	@Test 
//	public void getCompany() {
//		System.out.println(companyRepo.findById(206));
//	}
	
//	@Test 
//	public void getCoupon() {
//		System.out.println(couponRepo.findById(91));
//	}
//	
//	@Test 
//	public void getCoupon1() {
//		System.out.println(couponRepo.findById(2));
//	}
	
//	@Test 
//	public void customerGet() {
//		System.out.println(customerRepo.findById(1));
//	}

}

