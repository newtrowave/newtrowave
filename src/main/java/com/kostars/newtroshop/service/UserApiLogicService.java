package com.kostars.newtroshop.service;

import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.domain.user.User;
import com.kostars.newtroshop.domain.user.UserRepository;
import com.kostars.newtroshop.service.exception.UserFoundException;
import com.kostars.newtroshop.service.exception.UserNotFoundException;
import com.kostars.newtroshop.web.dto.request.UserApiRequest;
import com.kostars.newtroshop.web.dto.response.UserApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
                .name(userApiRequest.getName())
                .email(userApiRequest.getEmail())
                .picture(userApiRequest.getPicture())
                .role(userApiRequest.getRole())
                .phoneNumber(userApiRequest.getPhoneNumber())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        //3. 생성된 데이터 -> userApiResponse return
        return response(newUser);

    }

    @Override
    public Header<UserApiResponse> read(Long id) {

       /* // optional로 유저를 받고
        Optional<User> optional = userRepository.findById(id);

        // 유저가 있으면 map에 해당하는 것을 리턴 없으면 에러 넘김
        return optional
                .map(user -> response(user))
                .orElseGet(()->Header.ERROR("데이터 없음!"));*/

        // 위에 코드를 람다식으로 한 번에
        return userRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("데이터 없음!"));

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        // 1. data
        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user 데이터 를 찾고
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user -> {
            // 3. data -> update
            user.setName(userApiRequest.getName())
                    .setPicture(userApiRequest.getPicture())
                    .setEmail(userApiRequest.getEmail())
                    .setRole(userApiRequest.getRole())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUpdatedAt(userApiRequest.getUpdatedAt())
            ;
            return user;
        })
                .map(user -> userRepository.save(user))             // update -> newUser
                .map(updateUser -> response(updateUser))            // userApiResponse
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }


    @Override
    public Header delete(Long id) {

        // 1. id -> repository -> user
        Optional<User> optional = userRepository.findById(id);

        // 2. repository -> delete
        return optional.map(user -> {
            userRepository.delete(user);
            return Header.OK();
        })
                .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    private Header<UserApiResponse> response(User user) {
        // user-> userApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .picture(user.getPicture())
                .role(user.getRole())
                .phoneNumber(user.getPhoneNumber())
                .registeredAt(user.getRegisteredAt())
                .updatedAt(user.getUpdatedAt())
                .build();

        // Header + data return
        return Header.OK(userApiResponse);
    }

    public User findById(Long id) {
        verifyIfNotExistsUserWithGivenId(id);
        return userRepository.getOne(id);
    }
    private void verifyIfNotExistsUserWithGivenId(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()) {
            throw new UserNotFoundException();
        }
    }

    private void verifyIfUserWithGivenEmailExists(User user) {
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser.isPresent() && (user.isNew() || isUpdatingToADifferentUser(user, foundUser))) {
            throw new UserFoundException();
        }
    }
    private boolean isUpdatingToADifferentUser(User userAccount, Optional<User> foundUser) {
        return userAccount.exist() && !userAccount.equals(foundUser);
    }

}
