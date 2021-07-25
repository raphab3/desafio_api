package br.com.backend.desafio_api.modules.clients.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "clients")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Data
@AllArgsConstructor
public class Client implements Serializable {
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

    //    @OneToMany(mappedBy = "clientAddress", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    //    private List<Address> addresses;
    //
    //    @OneToMany(mappedBy = "clientOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    //    private List<Order> orders;
}
