package application.dao;

import application.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface CustomerRepo extends JpaRepository <Customer, Long> {
//
//    @Query("select DISTINCT cust from Customer cust join fetch cust.orders")
//    Collection<Customer> getCustomerByFetch();
//
//    @Query("select cust from Customer cust join fetch cust.orders where cust.id = :number")
//    Customer getCustomerFetchById(@Param("number") Long number);


}
