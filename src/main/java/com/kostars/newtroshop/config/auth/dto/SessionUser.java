package com.kostars.newtroshop.config.auth.dto;

import com.kostars.newtroshop.domain.address.Address;
import com.kostars.newtroshop.domain.user.User;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class SessionUser implements Serializable {

    private static final long serialVersionUID = 7494030733033500373L;

    private String name;
    private String email;
    private String picture;
    private String phoneNumber;
    private List<Address> addressList;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.phoneNumber = user.getPhoneNumber();
        this.addressList = user.getAddressList();
    }

}
