package com.fnd.games_store.orders.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "order_id")
    private String id;

    @Column(name = "order_date")
    private OffsetDateTime orderDate;

    @Column(name = "is_order_processed")
    private Boolean isOrderProcessed;


    public Order(OffsetDateTime orderDate, Boolean isOrderProcessed) {
        this.orderDate = orderDate;
        this.isOrderProcessed = isOrderProcessed;
    }
}
