package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.web.dto.request.UserApiRequest;
import com.kostars.newtroshop.web.dto.response.UserApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController implements CrudInterface<CartApiReqeust, CartApiResponse> {

    @ApiOperation(value = "장바구니 목록")
    @GetMapping
    public

}
