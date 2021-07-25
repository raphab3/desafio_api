package br.com.backend.desafio_api.modules.orders.entities;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "orders")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private Double amount;

//    @Column(name = "created_at")
//    @CreationTimestamp
//    private String createdAt;
//
//    @Column(name = "updated_at")
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;

    //    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    public Order() {
    }

    public Order(long l, double v) {
    }

//
//    public Order(long id, Double amount) {
//        this.id = id;
//        this.amount = amount;
//    }
}
