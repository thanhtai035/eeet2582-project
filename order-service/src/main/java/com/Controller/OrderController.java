package com.Controller;

import com.FeignClient.ItemClient;
import com.Model.Cart;
import com.Model.Item;
import com.Model.OrderDetail;
import com.Model.Orders;
import com.Service.CartService;
import com.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/orders/")
public class OrderController {

    @Autowired
    private ItemClient itemClient;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @GetMapping(path="{itemID}")
    public Item getItem(@PathVariable("itemID") Long itemID) {
        return itemClient.getItemById(itemID);
    }

    @PostMapping
    public void saveOrder(@RequestBody InfoHolder infoHolder) {
        Orders order = new Orders();

        Map<Long, Cart> cartMap = cartService.findAll();
        double total = 0;
        for (Map.Entry<Long, Cart> entry : cartMap.entrySet()) {
            OrderDetail buf = new OrderDetail();
            buf.setId(entry.getKey());
            buf.setQuantity(entry.getValue().getQuantity());
            buf.setItem(itemClient.getItemById(entry.getKey()));
            buf.setOrder(order);
            total = total + (buf.getItem().getPrice() * buf.getQuantity());
            orderService.saveOrderDetail(buf);
        }

        order.setAddress(infoHolder.getAddress());
        order.setNum(infoHolder.num);
        order.setName(infoHolder.getName());

        total = Math.round(total * 100.0) / 100.0;
        order.setTotal(total);
    }

}

class InfoHolder{
    String name;
    String address;
    String num;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNum() {
        return num;
    }
}
