package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int PRICE = 100;

    public FixPriceProduct(UUID id, String name) {
        super(id,name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return this.getName() + ":фиксированная цена " + PRICE;
    }

    @Override
    public UUID getId() {
        return null;
    }
}
