package com.do_again_first.the_first.Mapper;

import com.do_again_first.the_first.Dto.Request.UserCreationRequest;
import com.do_again_first.the_first.Dto.Response.UserResponse;
import com.do_again_first.the_first.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);

}
