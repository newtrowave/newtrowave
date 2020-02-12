package com.kostars.newtroshop.domain.cartItems;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemsRepository extends JpaRepository <CartItems, Long> {

}
