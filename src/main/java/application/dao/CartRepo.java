package application.dao;

import application.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart, Long> {

    @Query("select child from Cart child join fetch child.finalOrder where child.id = :number")
    Optional<Cart> getChildNotes(@Param("number") Long number);
}