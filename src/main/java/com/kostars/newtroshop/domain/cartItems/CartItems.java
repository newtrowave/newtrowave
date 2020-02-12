package com.kostars.newtroshop.domain.cartItems;

import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.user.User;
import lombok.*;
import lombok.experimental.Accessors;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"product"})
@Builder
@Accessors(chain = true)
public class CartItems {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long cartItemsId;

    @Column
    private Integer cartQuantity;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
