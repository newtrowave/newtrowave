package com.kostars.newtroshop.domain.user;

import com.kostars.newtroshop.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

     Optional<User> findByEmail(String email);
}
