package com.kostars.newtroshop.web;

import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.domain.cartItems.CartItems;
import com.kostars.newtroshop.service.CartItemService;
import com.kostars.newtroshop.service.CartService;
import com.kostars.newtroshop.service.ProductService;
import com.kostars.newtroshop.service.UserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

/*    @PostMapping(value = "/create")
    public ResponseEntity<String> createCart() {

        ShoppingCart cart = cartService.createCart();
        return new ResponseEntity<String>(String.valueOf(cart.getCartId()), HttpStatus.OK);
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingCart create(@Valid @RequestBody ShoppingCart cart) {
        return cartService.save(cart);
    }

    @GetMapping
    public ShoppingCart findByUser(@RequestParam Long userId) {
        return cartService.findCartByUser(userId);
    }
}


