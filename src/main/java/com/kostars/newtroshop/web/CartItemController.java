package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.domain.cartItems.CartItems;
import com.kostars.newtroshop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;


    // 카트 아이템 생성
    @PostMapping
    public CartItems create(@RequestBody CartItems cartItems) {
        return cartItemService.save(cartItems);
    }

    @PutMapping
    public CartItems updateCartItem(@RequestBody CartItems cartItems) {
        return cartItemService.updateCartItem(cartItems);
    }

    @GetMapping
    public CartItems findById(@RequestParam Long id) {
        return cartItemService.findById(id);
    }

    @DeleteMapping("/deleteCartItem")
    public void deleteCartItems(@RequestParam CartItems cartItems) {
        cartItemService.removeCartItem(cartItems);

    }
}
