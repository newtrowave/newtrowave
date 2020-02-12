package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.product.category.Category;
import com.kostars.newtroshop.domain.product.category.keyword.Keyword;
import com.kostars.newtroshop.domain.product.category.keyword.KeywordRepository;
import com.kostars.newtroshop.web.dto.request.KeywordRequestDto;
import com.kostars.newtroshop.web.dto.response.CategoryResponseDto;
import com.kostars.newtroshop.web.dto.response.KeywordResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.List;

@Service
public class KeywordService implements CrudInterface<KeywordRequestDto, KeywordResponseDto> {

    @Autowired
    private KeywordRepository keywordRepository;

    @Override
    public Header<KeywordResponseDto> create(Header<KeywordRequestDto> request) {

        KeywordRequestDto body = request.getData();

        Keyword keyword = Keyword.builder()
                .keywordName(body.getKeywordName())
                .keywordDescription(body.getKeywordDescription())
                .keywordImage(body.getKeywordImage())
                .build();

        Keyword newKeyword = keywordRepository.save(keyword);

        return response(newKeyword);
    }

    @Override
    public Header<KeywordResponseDto> read(Long id) {

        return keywordRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("No One Data"));
    }

    public Header<KeywordResponseDto> readAll() {

        List<Keyword> keywords = keywordRepository.findAll();

        return keywords.isEmpty() ? null : responseAll(keywords);
    }

    public Header<KeywordResponseDto> readAll(String keywordName) {
        List<Keyword> keywords = keywordRepository.findAllByKeywordNameContaining(keywordName);

        return keywords.isEmpty() ? null : responseAll(keywords);
    }

    @Override
    public Header<KeywordResponseDto> update(Header<KeywordRequestDto> request) {

        KeywordRequestDto body = request.getData();

        Keyword keyword = Keyword.builder()
                .keywordId(body.getKeywordId())
                .keywordName(body.getKeywordName())
                .keywordDescription(body.getKeywordDescription())
                .keywordImage(body.getKeywordImage())
                .build();

        Keyword newKeyword = keywordRepository.save(keyword);

        return response(newKeyword);
    }

    @Override
    public Header delete(Long id) {         // todo keyword delete 삭제 기능 구현


        return null;
    }

    private Header<KeywordResponseDto> response(Keyword keyword) {

        KeywordResponseDto body = KeywordResponseDto.builder()
                .keywordId(keyword.getKeywordId())
                .keywordName(keyword.getKeywordName())
                .keywordDescription(keyword.getKeywordDescription())
                .keywordImage(keyword.getKeywordImage())
                .build();

        return Header.OK(body);
    }

    private Header<KeywordResponseDto> responseAll(List<Keyword> keywords) {

        KeywordResponseDto body = KeywordResponseDto.builder()
                .keywords(keywords)
                .build();

        return Header.OK(body);
    }
}
