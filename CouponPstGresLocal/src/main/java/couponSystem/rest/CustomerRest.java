package couponSystem.rest;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import couponSystem.beans.Coupon;
import couponSystem.exception.CouponSystemException;
import couponSystem.facade.CustomerFacadeF;



// TODO: Auto-generated Javadoc
/**
 * The Class CustomerRest.
 */
@CrossOrigin("*")
@RestController 
public class CustomerRest {
	
	/** The customer. */
//	CustomerFacadeF customer = new CustomerFacadeF(5);
	
	
	@Autowired
	CustomerFacadeF myFacade;
	/**
	 * Purchase coupon.
	 *
	 * @param coupon the coupon
	 */
	@RequestMapping(value="/customer/purchaseCoupon/{id}" , method= RequestMethod.GET) 
	public @ResponseBody ResponseEntity purchaseCoupon(@PathVariable ("id") int id , HttpServletRequest request) {
		//CustomerFacadeF myFacade = (CustomerFacadeF) request.getSession().getAttribute("facade");
		myFacade.setCustomerLogged(186);
		try {
			myFacade.purchaseCoupon(id);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Coupon is Yours");
		} catch (CouponSystemException e) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).contentType(MediaType.APPLICATION_JSON).body(e.getMessage());
		}
	}
	
	/**
	 * Gets the my coupons.
	 *
	 * @return the my coupons
	 */
	@RequestMapping(value="/customer/getAllMyCoupons" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Coupon> getMyCoupons(HttpServletRequest request){
		//CustomerFacadeF myFacade = (CustomerFacadeF) request.getSession().getAttribute("facade");
		myFacade.setCustomerLogged(186);
		return myFacade.getAllMyCoupons();
	}
	
	/**
	 * Gets the coupons filtered.
	 *
	 * @param filter the filter
	 * @param refernce the reference
	 * @return the coupons filtered
	 */
	@RequestMapping(value="/customer/getMyCouponsSortedByType/{filter}/{reference}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Coupon> getCouponsFiltered(@PathVariable ("filter") String filter,@PathVariable  ("reference") String reference , 
			HttpServletRequest request) {
		//CustomerFacadeF myFacade = (CustomerFacadeF) request.getSession().getAttribute("facade");
		myFacade.setCustomerLogged(186);
		return myFacade.getMyCouponsSortedByType(filter , reference);
	}
	
	@RequestMapping(value="/customer/getAllCoupons/" , method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Coupon> getAllCoupons(HttpServletRequest request){
		//CustomerFacadeF myFacade = (CustomerFacadeF) request.getSession().getAttribute("facade");
		myFacade.setCustomerLogged(186);
		return myFacade.getAllCouponsToBuy();
	}

}
