package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        ;
        this.articles = new HashMap<>();
        ;
        createTestData();
    }

    private void createTestData() {
        Product apple = new SimpleProduct(UUID.randomUUID(), "Яблоко", 90);
        this.products.put(apple.getId(), apple);
        Product milk = new DiscountedProduct(UUID.randomUUID(), "Молоко", 120, 20);
        this.products.put(milk.getId(), milk);
        Product bread = new DiscountedProduct(UUID.randomUUID(), "Хлеб", 60, 10);
        this.products.put(bread.getId(), bread);
        Product beer1 = new DiscountedProduct(UUID.randomUUID(), "Пиво Балтика 1", 100, 10);
        this.products.put(beer1.getId(), beer1);
        Product beer2 = new FixPriceProduct(UUID.randomUUID(), "Пиво Балтика 22");
        this.products.put(beer2.getId(), beer2);
        Product beer3 = new FixPriceProduct(UUID.randomUUID(), "Пиво Балтика 333");
        this.products.put(beer3.getId(), beer3);
        Article bob = new Article(UUID.randomUUID(), "Губка", "Поролоновая губка, для мытья посуды губка");
        this.articles.put(bob.getId(), bob);
        Article rag = new Article(UUID.randomUUID(), "Тряпка", "Ворсовая тряпка, для мытья полов");
        this.articles.put(rag.getId(), rag);
        Article book1 = new Article(UUID.randomUUID(), "Воин на отшибе", "Заметка на злобу дня");
        this.articles.put(book1.getId(), book1);
        Article book2 = new Article(UUID.randomUUID(), "Один в поле не воин", "Эпос");
        this.articles.put(book2.getId(), book2);
        Article book3 = new Article(UUID.randomUUID(), "Воин, супервоин", "Фантастика");
        this.articles.put(book3.getId(), book3);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Searchable> allProductsAndArticles() {
        return Stream.concat(
                products.values().stream(),
                articles.values().stream()
        ).collect(Collectors.toList());
    }
}
