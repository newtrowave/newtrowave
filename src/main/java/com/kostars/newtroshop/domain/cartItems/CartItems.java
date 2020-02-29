package com.kostars.newtroshop.domain.cartItems;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.user.User;
import lombok.*;
import lombok.experimental.Accessors;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"product", "shoppingCart"})
public class CartItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long cartItemsId;

    private Integer cartQuantity;

    @Column
    private BigDecimal unitPrice;

    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "shoppingCartCartId")
    @JsonBackReference(value = "shoppingCart")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "productProductId")
    @JsonBackReference(value = "product")
    private Product product;

    public BigDecimal getSubtotal() {
        return product.getProductPrice().multiply(new BigDecimal(cartQuantity));
    }
}
