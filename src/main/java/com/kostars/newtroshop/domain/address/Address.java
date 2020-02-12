package com.kostars.newtroshop.domain.address;

import com.kostars.newtroshop.domain.user.User;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"user"})
@Builder
@Accessors(chain = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column
    private String zipCode;

    @Column
    private String address;

    @Column
    private String addressDetail;

    @ManyToOne
    private User user;

}
