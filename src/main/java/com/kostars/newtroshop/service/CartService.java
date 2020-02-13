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

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CartService  {

    @Autowired
    private ShoppingCartRepository cartRepository;
    @Autowired
    private CartItemsRepository cartItemRepository;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserApiLogicService userService;
    @Autowired
    private ProductService productService;

    @Transactional
    public ShoppingCart createCart(){
        return save(new ShoppingCart());
    }


    public ShoppingCart findCartByUser(Long  userId) {
        return cartRepository.findByUserId(userId);
    }
    public ShoppingCart save(ShoppingCart cart) {
        cart.setUser(userService.findById(cart.getUser().getId()));
        cart = cartRepository.save(cart);
        for (CartItems item: cart.getCartItemsList()) {
            item.setProduct(productService.findById(item.getProduct().getProductId()));
            item.setUnitPrice(item.getProduct().getProductPrice());
            item.setSubtotal(item.getUnitPrice().multiply(new BigDecimal(item.getCartQuantity())));
            item.setShoppingCart(cart);
        }
        cartItemRepository.saveAll(cart.getCartItemsList());
        updateCart(cart);
        return cart;
    }
    public ShoppingCart updateCart(ShoppingCart cart) {
        List<CartItems> cartItems = cartItemRepository.findByShoppingCart(cart);
        BigDecimal cartTotal = cartItems.stream()
                .map(CartItems::getSubtotal)
                .reduce(BigDecimal::add)
                .get();
        cart.setTotalPrice(cartTotal);
        return cartRepository.save(cart);
    }


}
