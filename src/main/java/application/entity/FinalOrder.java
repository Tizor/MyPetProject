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

    @Column(name = "total_price")
    private double totalPrice;

//    @OneToOne (optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="order_id")
//    private Cart cart; //  1 Вариант с двунаправленной связью OneToMany <-> ManyToOne

//    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL) //  1 Вариант с двунаправленной связью OneToMany <-> ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer; //  1 Вариант с двунаправленной связью OneToMany <-> ManyToOne

}
