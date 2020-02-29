package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.domain.cartItems.CartItems;
import com.kostars.newtroshop.domain.cartItems.CartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemsRepository cartItemsRepository;

    public List<CartItems> findByCart(ShoppingCart cart) {
        return cartItemsRepository.findByShoppingCart(cart);
    }

    public CartItems updateCartItem(CartItems cartItem) {
        cartItem.setCartQuantity(cartItem.getCartQuantity());
        BigDecimal subtotal = cartItem.getProduct().getProductPrice().multiply(new BigDecimal(cartItem.getCartQuantity()));
        cartItem.setSubtotal(subtotal);
        return cartItemsRepository.save(cartItem);
    }

    public CartItems findById(Long id) {
        return cartItemsRepository.getOne(id);
    }

    public void removeCartItem(CartItems cartItem) {
        cartItemsRepository.delete(cartItem);
    }

    public CartItems save(final CartItems cartItem) {
        return cartItemsRepository.save(cartItem);
    }

}
