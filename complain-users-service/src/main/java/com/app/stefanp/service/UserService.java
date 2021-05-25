package com.app.stefanp.service;

import com.app.stefanp.dto.GetUserDto;
import com.app.stefanp.exceptions.AppException;
import com.app.stefanp.mappers.Mapper;
import com.app.stefanp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public GetUserDto findById(Long id)
    {
        if (Objects.isNull(id))
        {
            throw new AppException("USER ID IS NULL");
        }
        return userRepository
                .findById(id)
                .map(Mapper::fromUserToGetUserDto)
                .orElseThrow(() -> new AppException("CANNOT FIND USER WITH ID: " + id));
    }

    public GetUserDto findByUsername(String username)
    {
        if (Objects.isNull(username))
        {
            throw new AppException("USER ID IS NULL");
        }
        return userRepository
                .findByUsername(username)
                .map(Mapper::fromUserToGetUserDto)
                .orElseThrow(() -> new AppException("CANNOT FIND USER WITH USERNAME: " + username));
    }

    public List<GetUserDto> getAllUsers()
    {
        return userRepository
                .findAll()
                .stream()
                .map(Mapper::fromUserToGetUserDto)
                .collect(Collectors.toList());
    }

    public Long deleteUser(Long id)
    {
        if (Objects.isNull(id))
        {
            throw new AppException("USER ID IS NULL");
        }

        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new AppException("CANNOT FIND USER WITH ID: " + id));
        userRepository.deleteById(id);
        return user.getId();
    }


}
