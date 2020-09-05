package application.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "create_Date")
    private Date createDate;

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @JsonIgnoreProperties( "product" )
//    private Collection<Cart> cart = new ArrayList<>();
}
