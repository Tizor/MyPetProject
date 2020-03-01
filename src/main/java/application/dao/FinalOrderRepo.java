package application.dao;

import application.entity.FinalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface FinalOrderRepo extends JpaRepository<FinalOrder, UUID> {}