package com.kostars.newtroshop.domain;

import com.kostars.newtroshop.NewtroshopApplicationTests;
import com.kostars.newtroshop.domain.category.keyword.Keyword;
import com.kostars.newtroshop.domain.category.keyword.KeywordRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

public class KeywordSearchTest extends NewtroshopApplicationTests {

    @Autowired
    private KeywordRepository keywordRepository;

    @Test
    public void searchAllKeyword() {
        List<Keyword> keyword = keywordRepository.findAll();

        Assert.notNull(keyword, "List");
    }

    @Test
    public void searchKeywordKey() {
        Optional<Keyword> keyword = keywordRepository.findById(17l);

        keyword.ifPresent(key -> {
            System.out.println(key);
        });
    }

    @Test
    public void searchTagKey() {
        List<Keyword> keyword = keywordRepository.findAllByKeywordNameContaining("드");
        Assert.notEmpty(keyword, "이건 비어있따.");

        keyword.forEach(item-> {
            System.out.println("item : " + item);
        });
    }

}
