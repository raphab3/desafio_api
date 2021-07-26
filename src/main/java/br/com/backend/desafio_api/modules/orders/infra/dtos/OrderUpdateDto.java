package br.com.backend.desafio_api.modules.orders.infra.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderUpdateDto {
    private final Double amount;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
