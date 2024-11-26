package com.do_again_first.the_first.Service;

import com.do_again_first.the_first.Dto.Request.UserCreationRequest;
import com.do_again_first.the_first.Dto.Response.UserResponse;
import com.do_again_first.the_first.Entities.User;
import com.do_again_first.the_first.Exception.AppException;
import com.do_again_first.the_first.Exception.ErrorCode;
import com.do_again_first.the_first.Mapper.UserMapper;
import com.do_again_first.the_first.Reponsitory.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    UserMapper userMapper;
    public User createUser(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
            User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
            return userRepository.save(user);
    }



}
