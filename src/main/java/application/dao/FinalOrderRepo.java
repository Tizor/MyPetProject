package application.dao;


import application.entity.Customer;
import application.entity.FinalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface FinalOrderRepo extends JpaRepository<FinalOrder, Long> {

//    @Query("select DISTINCT ord from FinalOrder ord join fetch ord.customer")
//    Collection<FinalOrder> getOrderByFetch();


    @Query("select child from FinalOrder child where child.customer.id = :number")
    Collection<FinalOrder> getChildNotes(@Param("number") Long number);

}
