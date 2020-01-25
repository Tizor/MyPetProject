package application.dao;

import application.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface CustomerRepo extends JpaRepository <Customer, UUID> {}
