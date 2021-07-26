package br.com.backend.desafio_api.modules.clients.entities;

import br.com.backend.desafio_api.modules.addresses.entities.Address;
import br.com.backend.desafio_api.modules.orders.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clients")
public class Client implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "birthDate")
    private String birthDate;

    @OneToMany(mappedBy = "clientAddress", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

//    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "clientOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

}
