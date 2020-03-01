package application.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "final_order")
public class FinalOrder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "cart_id")
    private UUID cartId;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL) //  1 Вариант с двунаправленной связью OneToMany <-> ManyToOne
    private Customer customer; //  1 Вариант с двунаправленной связью OneToMany <-> ManyToOne

}
