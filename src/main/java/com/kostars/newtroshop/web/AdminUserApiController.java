package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.service.UserApiLogicService;
import com.kostars.newtroshop.web.dto.request.UserApiRequest;
import com.kostars.newtroshop.web.dto.response.UserApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/admin/user")
public class AdminUserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        // Log.info("{}",request);  <--쓰면 오류 뜸 ㅠ
        return userApiLogicService.create(request);
    }

    @Override
    @ApiOperation(value = "회원 조회")
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        return userApiLogicService.read(id);
    }

    @Override
    @ApiOperation(value = "회원 수정")
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return userApiLogicService.update(request);
    }

    @Override
    @ApiOperation(value = "회원 삭제")
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return userApiLogicService.delete(id);
    }
}
