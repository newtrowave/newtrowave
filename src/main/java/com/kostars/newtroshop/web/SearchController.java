package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.category.keyword.Keyword;
import com.kostars.newtroshop.domain.category.keyword.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

현재 test 중인 클래스 입니다.

*/

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private KeywordRepository keywordRepository;

    @GetMapping(value = "{tag}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody List<Keyword> searchingTester(@PathVariable String tag) {      // todo - 여기 또한 gson을 쓸지 말지 모르겠음
        List<Keyword> keywords = keywordRepository.findAllByKeywordNameContaining(tag);
        System.out.println(keywords);
        return keywords;
    }

}
