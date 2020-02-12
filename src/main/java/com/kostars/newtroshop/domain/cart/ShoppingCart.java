package com.kostars.newtroshop.domain.cart;

import com.kostars.newtroshop.domain.cartItems.CartItems;
import com.kostars.newtroshop.domain.user.User;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"user", "cartItemsList"})
@Builder
@Accessors(chain = true)
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<CartItems> cartItemsList;
}
