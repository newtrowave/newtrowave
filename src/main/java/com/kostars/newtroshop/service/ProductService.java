package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.ProductRepository;
import com.kostars.newtroshop.web.dto.request.ProductRequestDto;
import com.kostars.newtroshop.web.dto.response.ProductResponseDto;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class ProductService implements CrudInterface<ProductRequestDto, ProductResponseDto> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Header<ProductResponseDto> create(Header<ProductRequestDto> request) {

        ProductRequestDto body = request.getData();

        Product product = Product.builder()
                .productName(body.getProductName())
                .productPrice(body.getProductPrice())
                .productContent(body.getProductContent())
                .productColor(body.getProductColor())
                .createdAt(LocalDateTime.now())
                .productStock(body.getProductStock())
                .build();

        Product p = productRepository.save(product);

        return response(p);
    }

    public List<MultipartFile> upload(List<MultipartFile> files) throws Exception {
        LocalDate date = LocalDate.now();
        String originalPath = "C:\\upload\\tmp";

        for (MultipartFile m : files) {
            String path = originalPath;
            UUID uuid = UUID.randomUUID();

            if (m.getSize() > (100 * 1024 * 1024)) throw new IOException("파일 크기 초과");     // 100MB

            String fileName = uuid + "_" + m.getOriginalFilename();

            if (m.getContentType().contains("image")) {
                path += "\\image";
            } else {
                path += "\\files";
            }

            path += "\\" + date.getDayOfMonth();

            File pathFolder = new File(path);
            File file = new File(path, fileName);

            if (!pathFolder.exists()) {
                pathFolder.mkdirs();
            }

            try {
                m.transferTo(file);

                if (file.exists()) {
                    File thumbnailDir = new File(originalPath + "\\image\\thumbnails");

                    if(!thumbnailDir.exists()) thumbnailDir.mkdirs();

                    Thumbnails.of(file).size(270, 300).toFile(thumbnailDir.getAbsolutePath() + "\\thumb_" + file.getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    public Header<ProductResponseDto> read(Long id) {

        return productRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("NO DATA"));

    }

    public Header<ProductResponseDto> readAll() {
        List<Product> products = productRepository.findAll();

        System.out.println("PRODUCT SERVICE #54 : " + products);

        return responseList(products);
    }

    @Override
    public Header<ProductResponseDto> update(Header<ProductRequestDto> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<ProductResponseDto> response(Product product) {

        ProductResponseDto body = ProductResponseDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productColor(product.getProductColor())
                .productContent(product.getProductContent())
                .createdAt(product.getCreatedAt())
                .productStock(product.getProductStock())
                .build();

        return Header.OK(body);
    }

    private Header<ProductResponseDto> responseList(List<Product> list) {
        ProductResponseDto body = ProductResponseDto.builder()
                .products(list)
                .build();

        return Header.OK(body);
    }
}
