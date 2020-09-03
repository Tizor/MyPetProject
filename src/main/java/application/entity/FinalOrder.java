package application.entity;

import lombok.*;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "final_order")
public class FinalOrder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "order_number")
    private UUID orderNumber;


//    @XmlInverseReference(mappedBy="orders")
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
