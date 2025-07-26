package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    private final String name;
    private final String text;

    public Article(UUID id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.text;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return this.getName();
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

