package couponSystem.beans;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
// TODO: Auto-generated Javadoc

/**
 * The Class Customer.
 *
 * 		   Company Class - Attributes : id , custName , password ; 
 *         Constructor with all attributes - Getter and Setters for each
 *         attribute
 */
@Entity(name="CUSTOMER")
@XmlRootElement
public class Customer {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The cust name. */
	@Column
	private String custName;

	/** The password. */
	@Column
	private String password;

	/** The coupon. */
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.REFRESH })
	@JoinTable(name = "customer_coupon",
						joinColumns = @JoinColumn(name = "customer_id"),
						inverseJoinColumns = @JoinColumn(name = "coupon_id"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore 
	private Collection<Coupon> coupons;

	public Collection<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(Collection<Coupon> coupons) {
		this.coupons = coupons;
	}
	/**
	 * Instantiates a new customer.
	 *
	 * @param id       the id
	 * @param custName the cust name
	 * @param password the password
	 */
	
	public Customer() {
		super();
	}
	

	public Customer(int id, String custName, String password, Collection<Coupon> coupons) {
		super();
		this.id = id;
		this.custName = custName;
		this.password = password;
		this.coupons = coupons;
	}
	
	public void buyCoupon(Coupon coupon) {
		Collection<Coupon> coupons = null ; 
		coupons = this.getCoupons();
		coupons.add(coupon);
	} 
	
	public boolean ifCouponsPurchased(int id) {
		boolean result = false ;
		Collection<Coupon> coupons = this.getCoupons();
		for (Coupon coupon : coupons) {
			if (coupon.getId()==id) {
				result = true ; 
				break; 
			}
		}
		return result; 
	}
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the cust name.
	 *
	 * @return the cust name
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * Sets the cust name.
	 *
	 * @param custName the new cust name
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + ", coupons=" + coupons
				+ "]";
	}

}
