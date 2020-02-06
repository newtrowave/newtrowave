package com.kostars.newtroshop.domain;

import com.kostars.newtroshop.NewtroshopApplicationTests;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.ProductRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductTest extends NewtroshopApplicationTests {



    @Autowired
    private ProductRepository productRepository;

    public void cleanUp() {

        productRepository.deleteAll();
    }

    @Test
    public void 상품저장() {
        productRepository.save(Product.builder()
                .productName("AKG")
                .productPrice(BigDecimal.valueOf(39900))
                .productContent("")
                .createdAt(LocalDateTime.now())
                .productStock(810)
                .build()
        );

        List<Product> products = productRepository.findAll();

        Product product = products.get(0);

        System.out.println(product.getProductName());
        System.out.println(product.getProductContent());
        System.out.println(product.getProductPrice());
    }

    @Test
    public void 상품수정 () {
        productRepository.findById(3l)
                .ifPresent(productEntity -> {
                    productEntity.setProductName("엠지텍 아이언V60");
                    productEntity.setProductPrice(BigDecimal.valueOf(99000));
                    productEntity.setProductContent("");

                    productRepository.save(productEntity);
                });
    }

    @Test
    public void 상품삭제 () {
        productRepository.findById(13l)
                .ifPresent(productEntity -> {
                    productRepository.deleteById(productEntity.getProductId());
                });
    }
}
