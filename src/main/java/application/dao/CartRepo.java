package application.dao;

import application.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CartRepo extends JpaRepository<Cart, UUID> {}