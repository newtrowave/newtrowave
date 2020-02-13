package com.kostars.newtroshop.domain;

import com.kostars.newtroshop.NewtroshopApplicationTests;
import com.kostars.newtroshop.domain.product.Files;
import com.kostars.newtroshop.domain.product.FilesRepository;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.ProductRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

public class FilesRepositoryTest extends NewtroshopApplicationTests {

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void test() {
        Optional<Product> p = productRepository.findById(3l);

        Product product = p.get();

        filesRepository.save(Files.builder()
                .fileUrl("url3")
                .fileName("name3")
                .product(product)
                .build());
    }

    @Test
    @Transactional
    public void readAll() {
        Product p = productRepository.findById(3l).get();
        System.out.println(filesRepository.findAllByProduct(p));
    }
}
