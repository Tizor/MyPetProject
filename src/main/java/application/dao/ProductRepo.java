package application.dao;

import application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, Long> {}