package kr.co.hanbit.product.management.presentation;

import jakarta.validation.constraints.NotNull;
import kr.co.hanbit.product.management.domain.Product;

public class ProductDto {
    private Long id;
    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer amount;

    public ProductDto() {};

    public ProductDto(String name, Integer price, Integer amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public ProductDto(String name, Integer amount, Long id ,Integer price){
        this.name = name;
        this.amount = amount;
        this.id = id;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public static Product toEntity(ProductDto productDto) {
        Product product= new Product();

//        product.setId(productDto.getId()); // 이거 고쳐야함 이게 문제가 아니라 그 getId()햇을 때 애초에 변수에 id값이 저장이 안되는듯
        // 근데 안되는 이유가 디비 자동설정이라는데 흠...
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setAmount(productDto.getAmount());

        return product;
    }

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getName(),
                product.getPrice(),
                product.getAmount()
        );

        productDto.setId(product.getId());

        return productDto;

    }
}
