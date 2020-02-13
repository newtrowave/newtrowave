package com.kostars.newtroshop.domain.user;

import com.kostars.newtroshop.domain.address.Address;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@ToString(exclude = {"addressList"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column
    private String phoneNumber;

    @CreatedDate
    private LocalDateTime registeredAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Address> addressList;

    @Builder
    public User(String name, String email, String picture, Role role, String phoneNumber, LocalDateTime registeredAt) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.registeredAt = registeredAt;
    }

    @Builder
    public User(Long id,String name, String email, String picture, Role role, String phoneNumber, LocalDateTime registeredAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.registeredAt = registeredAt;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public boolean isNew() {
        return this.id== null;
    }
    public boolean exist() {
        return this.id != null;
    }
}
