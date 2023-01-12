package com.Controller;

import com.Model.Cart;
import com.Model.Item;
import com.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/carts/")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public void save(@RequestBody Cart cart) {
        cartService.save(cart.getItemID(), cart);
    }

    @GetMapping
    public Map<Long, Cart> findAll() {
        return cartService.findAll();
    }

    @PostMapping(value = "/clear")
    public void clearCart() {
        cartService.clearCart();
    }

    @DeleteMapping(path = "{id}")
    public void deleteCart(@PathVariable("id") Long cartID) {
        cartService.delete(cartID);
    }

}
