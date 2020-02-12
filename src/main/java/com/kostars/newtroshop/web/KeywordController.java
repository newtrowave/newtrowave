package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.service.KeywordService;
import com.kostars.newtroshop.web.dto.request.KeywordRequestDto;
import com.kostars.newtroshop.web.dto.response.KeywordResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keyword")
public class KeywordController implements CrudInterface<KeywordRequestDto, KeywordResponseDto> {

    @Autowired
    private KeywordService keywordService;

    @Override
    @PostMapping("")
    public Header<KeywordResponseDto> create(Header<KeywordRequestDto> request) {

        return keywordService.create(request);
    }

    @Override
    @GetMapping("{keywordId}")
    public Header<KeywordResponseDto> read(@PathVariable Long keywordId) {
        return keywordService.read(keywordId);
    }

    @GetMapping("")
    public Header<KeywordResponseDto> readAll() {
        return keywordService.readAll();
    }

    @GetMapping("/list/{keywordName}")
    public Header<KeywordResponseDto> readAll(@PathVariable String keywordName) {
        return keywordService.readAll(keywordName);
    }

    @Override
    @PutMapping("")
    public Header<KeywordResponseDto> update(Header<KeywordRequestDto> request) {
        return keywordService.update(request);
    }

    @Override
    @DeleteMapping("{keywordId}")
    public Header delete(@PathVariable Long keywordId) {
        return keywordService.delete(keywordId);
    }
}
