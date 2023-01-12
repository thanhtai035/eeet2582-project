package com.Service;

import com.FeignClient.ItemClient;
import com.Model.Cart;
import com.Model.Item;
import com.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Cart> hashOperations;

    @PostConstruct
    private void initializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }


    public void save(Long itemID, Cart cart) {
        hashOperations.put("CART", itemID, cart);
    }

    public Cart findById(final Long id) {
        return (Cart) hashOperations.get("CART", id);
    }

    public Map<Long, Cart> findAll() {
        return (Map<Long,Cart>) hashOperations.entries("CART");
    }

    public void delete(Long id) {
        hashOperations.delete("CART", id);
    }

    public void clearCart() {
        hashOperations.entries("CART").clear();
    }
}
