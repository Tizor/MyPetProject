package application.entity;

import lombok.RequiredArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Entity
@Data
@RequiredArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer") // 1 Вариант с двунаправленной связью OneToMany <-> ManyToOne
//    @OneToMany(cascade = CascadeType.ALL)  // 2 Вариант с однонаправленной связью OneToMany и JoinColumn
//    @JoinColumn(name = "id")  // 2 Вариант с однонаправленной связью OneToMany и JoinColumn (name = ForeignKey)
    private Collection<FinalOrder> customerOrders;

}
