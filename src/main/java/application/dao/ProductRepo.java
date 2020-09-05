package application.dao;

import application.entity.Customer;
import application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, Long> {

//    @Query("select cust from Product cust join fetch cust.cart where cust.id = :number")
//    Optional<Product> getProductFetchById(@Param("number") Long number);

}