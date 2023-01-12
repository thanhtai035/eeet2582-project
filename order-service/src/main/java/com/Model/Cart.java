package com.Model;

import java.io.Serializable;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    Long itemID;
    Long quantity;

    public Long getItemID() {
        return itemID;
    }

    public Long getQuantity() {
        return quantity;
    }
}
