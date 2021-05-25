package com.app.stefanp.mappers;



import com.app.stefanp.dto.CreateUserDto;
import com.app.stefanp.dto.GetUserDto;
import com.app.stefanp.model.User;

import java.util.Objects;

public interface Mapper
{
    static User fromCreateUserDtoToUser(CreateUserDto createUserDto)
    {
        return Objects.isNull(createUserDto) ? null : User
                .builder()
                .username(createUserDto.getUsername())
                .password(createUserDto.getPassword())
                .role(createUserDto.getRole())
                .build();
    }

    static GetUserDto fromUserToGetUserDto(User user)
    {
        return Objects.isNull(user) ? null : GetUserDto
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }



}
