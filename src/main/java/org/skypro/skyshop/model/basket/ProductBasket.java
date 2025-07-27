package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void addProduct(UUID productId) {
        if (basket.containsKey(productId)) {
            basket.put(productId, basket.get(productId) + 1);
        } else {
            basket.put(productId, 1);
        }
    }

    public Map<UUID, Integer> getProducts() {
        return Collections.unmodifiableMap(basket);
    }
}
