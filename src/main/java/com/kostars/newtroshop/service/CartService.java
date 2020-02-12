package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.domain.cart.ShoppingCartRepository;
import com.kostars.newtroshop.domain.cartItems.CartItems;
import com.kostars.newtroshop.domain.cartItems.CartItemsRepository;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.ProductRepository;
import com.kostars.newtroshop.domain.user.User;
import com.kostars.newtroshop.domain.user.UserRepository;
import com.kostars.newtroshop.web.dto.request.UserApiRequest;
import com.kostars.newtroshop.web.dto.response.UserApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class CartService  {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ShoppingCart addToCart(Long userId, CartItems cartItems, User user){
        ShoppingCart shoppingCart = new ShoppingCart(userId);
        shoppingCart.getCartItemsList().put
    }

    @Transactional
    public List<CartItems> find(Long userId) {
        return cartItemsRepository.findAllById(userId);
    }

}
