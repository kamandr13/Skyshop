package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BasketService {
    private final StorageService storageService;
    private final ProductBasket basket;

    public BasketService(ProductBasket basket, StorageService storageService) {
        this.basket = basket;
        this.storageService = storageService;
    }

    public void addProduct(UUID id) {
        if (!storageService.getProductById(id).isEmpty()) {
            basket.addProduct(id);
        }
    }

    public UserBasket getUserBasket() {
        List<BasketItem> items = basket.getProducts()
                .entrySet()
                .stream()
                .map(el -> new BasketItem(storageService.getProductById(el.getKey()).orElseThrow(), el.getValue()))
                .toList();
        return new UserBasket(items);
    }
}
