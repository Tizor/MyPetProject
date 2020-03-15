package application.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "total_price_for_product")
    private Double totalPriceForProduct;

    @Column(name = "total_price_for_cart")
    private Double totalPriceForCart;

    @Column(name = "product_amount")
    private Long productAmount;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cart") // 1 Вариант с двунаправленной связью OneToMany <-> ManyToOne
//    @OneToMany(cascade = CascadeType.ALL)  // 2 Вариант с однонаправленной связью OneToMany и JoinColumn
//    @JoinColumn(name = "cart_id")  // 2 Вариант с однонаправленной связью OneToMany и JoinColumn (name = ForeignKey)
    private Collection<Product> productInCart;
}
