package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private int percentDiscount;

    public DiscountedProduct(UUID id, String name, int basicPrice, int percentDiscount) {
        super(id, name);
        if (basicPrice < 1) {
            throw new IllegalArgumentException("Базовая цена продукта меньше 1");
        }
        this.basicPrice = basicPrice;
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("Скидка не в диапазоне от 0 до 100");
        }
        this.percentDiscount = percentDiscount;
    }

    @Override
    public int getPrice() {
        return basicPrice - basicPrice * percentDiscount / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return this.getName() + ":" + getPrice() + "(" + this.percentDiscount + "%)";
    }

    @Override
    public UUID getId() {
        return null;
    }
}
