package com.app.stefanp.controllers;

import com.app.stefanp.dto.GetUserDto;
import com.app.stefanp.dto.ResponseData;
import com.app.stefanp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserServiceController
{

    private final UserService userService;

    @GetMapping
    public ResponseData<List<GetUserDto>> getAll()
    {
        return ResponseData
                .<List<GetUserDto>>builder()
                .data(userService.getAllUsers())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseData<GetUserDto> getOneById(@PathVariable Long id)
    {
        return ResponseData
                .<GetUserDto>builder()
                .data(userService.findById(id))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseData<Long> deleteOneById(@PathVariable Long id)
    {
        return ResponseData
                .<Long>builder()
                .data(userService.deleteUser(id))
                .build();

    }











}



