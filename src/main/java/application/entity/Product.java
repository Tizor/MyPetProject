package application.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_amount")
    private Long productAmount;

    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL) //  1 Вариант с двунаправленной связью OneToMany <-> ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart; //  1 Вариант с двунаправленной связью OneToMany <-> ManyToOne
}
