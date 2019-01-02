package couponSystem.rest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import couponSystem.facade.ClientCouponFacade;
import couponSystem.logIn.LogInService;



@Controller
public class LogIn {

	@Autowired 
	LogInService loginService; 
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public  String doPostRedirect(
		
				@RequestParam String name, @RequestParam String pwd, @RequestParam String usertype,
				HttpServletRequest request
			)
	{
		
		// check which usertype we got!
		ClientCouponFacade cf = loginService.logIn(usertype, name, pwd); // should be get instance
		
		if (cf == null) // login failed!
		{
			System.out.println("wrong Log in , go back");
			return "redirect:http://localhost:8082/index.html";
		}

		// success!
		System.out.println("Log in Succefull");
		request.getSession().setAttribute("facade", cf);
		
		// now redirect to the correct page!
		switch (usertype)
		{
			case "admin":
					System.out.println("on going");
					return "redirect:http://localhost:8082/admin/index.html";
			case "company":
					return "redirect:http://localhost:8082/company/index.html";
			case "customer":
					return "redirect:http://localhost:8082/customer/index.html";
		}
		
		return "redirect:http://localhost:8082/index.html";
	}
			
			
}