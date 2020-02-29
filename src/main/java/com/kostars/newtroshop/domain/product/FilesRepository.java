package com.kostars.newtroshop.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilesRepository extends JpaRepository<Files, Long> {

    List<Files> findAllByProduct(Product product);

}
