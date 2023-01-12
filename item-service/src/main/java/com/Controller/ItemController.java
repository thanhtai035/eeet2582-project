package com.Controller;

import com.Model.Item;
import com.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @GetMapping(path = "{id}")
    public Item getItemById(@PathVariable("id") Long itemID) {
        return itemService.getItemById(itemID);
    }
}
