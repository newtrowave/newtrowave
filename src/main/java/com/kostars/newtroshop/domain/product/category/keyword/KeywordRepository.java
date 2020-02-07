package com.kostars.newtroshop.domain.product.category.keyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    List<Keyword> findAllByKeywordNameContaining(String keywordName);

}
