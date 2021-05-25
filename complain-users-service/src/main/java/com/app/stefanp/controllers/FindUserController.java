package com.app.stefanp.controllers;


import com.app.stefanp.dto.GetUserDto;
import com.app.stefanp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
@RequiredArgsConstructor
public class FindUserController {
    private final UserService userService;

    @GetMapping("/username/{username}")
    public GetUserDto findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/id/{id}")
    public GetUserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
