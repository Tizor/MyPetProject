package application.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "quanity")
    private Long quanity;

    @Column(name = "amount")
    private Long amount;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private FinalOrder finalOrder;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id")
//    private Product product;

}
