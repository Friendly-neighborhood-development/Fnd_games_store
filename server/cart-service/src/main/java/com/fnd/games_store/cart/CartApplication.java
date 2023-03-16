package com.fnd.games_store.cart;


import com.fnd.games_store.cart.dto.OrderDTO;
import com.fnd.games_store.cart.entity.Cart;
import com.fnd.games_store.cart.entity.Game;
import com.fnd.games_store.cart.exception.CartNotFoundException;
import com.fnd.games_store.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.core.KafkaTemplate;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class CartApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class,args);
    }

    @Autowired
    private KafkaTemplate<String, OrderDTO> kafkaTemplate;

    @Autowired
    protected CartRepository repository;

    protected String userId = "user_1";


    protected List<Game> testCartGameData= new ArrayList<>();

    protected Cart testCart = new Cart();


    @Override
    public void run(String... args) throws Exception {
        repository.save(testCart);
        OrderDTO messageToOrdersService = new OrderDTO();
        sendMessage("order-stream", messageToOrdersService);
        System.out.println("===================="+ InetAddress.getLocalHost().getHostAddress()+"=====================");
    }




    private Optional<Cart> eraseCart(String userId) {

        Optional<Cart> foundCartData = repository.findById(userId);

        if (foundCartData.isPresent()){
            repository.deleteById(userId);
        } else throw new CartNotFoundException("Cart not found");

        return foundCartData;
    }

    private void confirmPurchase(String userId){

    }

    private void sendMessage(String topicName, OrderDTO orderData) {
        kafkaTemplate.send(topicName, orderData);

    }


}
