package com.app.stefanp.service;

import com.app.stefanp.dto.CreateUserDto;
import com.app.stefanp.exceptions.RegisterServiceException;
import com.app.stefanp.mappers.Mapper;
import com.app.stefanp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public Long register(CreateUserDto createUserDto)
    {
        validate(createUserDto);
        var user = Mapper.fromCreateUserDtoToUser(createUserDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository
                .save(user)
                .getId();
    }


    private void validate(CreateUserDto createUserDto)
    {
        if (Objects.isNull(createUserDto))
        {
            throw new RegisterServiceException("CREATE USER DTO IS NULL");
        }

        if (Objects.isNull(createUserDto.getUsername()))
        {
            throw new RegisterServiceException("USERNAME IS NULL");
        }

        if (Objects.isNull(createUserDto.getRole()))
        {
            throw new RegisterServiceException("ROLE IS NULL");
        }

        if (!Objects.equals(createUserDto.getPassword(), createUserDto.getPasswordConfirmation()))
        {
            throw new RegisterServiceException(("PASSWORD AND PASSWORD CONFIRMATION ARE DIFFERENT"));
        }

    }

}
