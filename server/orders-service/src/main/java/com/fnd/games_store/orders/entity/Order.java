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


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "order_game",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name ="game_id")})
    private List<Game> games = new ArrayList<>();

    public Order(OffsetDateTime orderDate, Boolean isOrderProcessed, List<Game> games) {
        this.orderDate = orderDate;
        this.isOrderProcessed = isOrderProcessed;
        this.games = games;
    }


    public void addGame(Game game){
        games.add(game);
        game.getOrder().add(this);
    }

    public void removeGame(Game game){
        games.remove(game);
        game.getOrder().remove(this);


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(orderDate, order.orderDate) && Objects.equals(isOrderProcessed, order.isOrderProcessed) && Objects.equals(games, order.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, isOrderProcessed, games);
    }
}
