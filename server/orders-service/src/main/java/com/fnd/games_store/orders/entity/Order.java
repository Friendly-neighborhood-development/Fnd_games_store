package com.fnd.games_store.orders.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {

    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "order_id")
    @ToString.Exclude
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "order_date")
    private OffsetDateTime orderDate;

    @Column(name = "is_order_processed")
    private Boolean isOrderProcessed;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "order_game",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name ="game_id")})
    private List<Game> games = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(userId, order.userId) && Objects.equals(isOrderProcessed, order.isOrderProcessed) && Objects.equals(games, order.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, isOrderProcessed, games);
    }

}
