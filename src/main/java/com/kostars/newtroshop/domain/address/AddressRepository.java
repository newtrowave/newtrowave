package com.kostars.newtroshop.domain.address;

import com.kostars.newtroshop.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findAllByUser(User user);

}
