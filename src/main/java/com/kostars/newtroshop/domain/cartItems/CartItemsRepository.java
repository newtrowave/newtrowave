package com.kostars.newtroshop.domain.cartItems;

import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemsRepository extends JpaRepository <CartItems, Long> {

    List<CartItems> findByShoppingCart(ShoppingCart shoppingCart);

    Optional<CartItems> findByProduct(Product product);

}
