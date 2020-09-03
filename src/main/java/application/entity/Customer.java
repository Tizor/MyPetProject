package application.entity;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Long age;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @XmlTransient
    @OneToMany(mappedBy = "customer")
    private Collection<FinalOrder> orders = new ArrayList<>();

}
