package com.FeignClient;

import com.Model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-service", url = "http://localhost:8080/")
public interface ItemClient {
    @GetMapping(value = "/api/items/{id}")
    public Item getItemById(@PathVariable(value = "id") Long itemID);
}
