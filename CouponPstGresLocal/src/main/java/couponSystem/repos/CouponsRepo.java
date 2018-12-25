package couponSystem.repos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import couponSystem.beans.Coupon;
public interface CouponsRepo extends CrudRepository <Coupon , Integer>{
	
	public boolean existsByTitle(String title);
	public ArrayList<Coupon> findByCustomers_id(int customerId);

}
