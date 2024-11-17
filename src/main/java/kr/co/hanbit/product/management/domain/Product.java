package kr.co.hanbit.product.management.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Product {
    private Long id;

    @Size(min = 1, max = 100)
    private String name;

    @Max(1_000_000)
    @Min(0)
    private Integer price;

    public void setName(@Size(min = 1, max = 100) String name) {
        this.name = name;
    }

    public void setPrice(@Max(1_000_000) @Min(0) Integer price) {
        this.price = price;
    }

    public void setAmount(@Max(999_999) @Min(0) Integer amount) {
        this.amount = amount;
    }

    @Max(999_999)
    @Min(0)
    private Integer amount;

    public void setId(long id) {
        this.id = id;
    }

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }

    public Boolean containsName(String name) {
        return this.name.contains(name);
    }

    public @Size(min = 1, max = 100) String getName() {
        return name;
    }

    public @Max(1_000_000) @Min(0) Integer getPrice() {
        return price;
    }

    public @Max(999_999) @Min(0) Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }
}
