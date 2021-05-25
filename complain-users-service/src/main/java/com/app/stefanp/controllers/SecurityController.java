package com.app.stefanp.controllers;


import com.app.stefanp.dto.CreateUserDto;
import com.app.stefanp.dto.ResponseData;
import com.app.stefanp.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/security")
public class SecurityController
{
    private final RegistrationService registrationService;
    //private final TokensService tokensService;

    @PostMapping("/register")
    public ResponseData<Long> registerUser(@RequestBody CreateUserDto createUserDto)
    {
        return ResponseData
                .<Long>builder()
                .data(registrationService.register(createUserDto))
                .build();
    }

}
