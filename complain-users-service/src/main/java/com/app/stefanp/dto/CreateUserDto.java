package com.app.stefanp.dto;

import com.app.stefanp.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto
{
    private String username;
    private String password;
    private String passwordConfirmation;
    private Role role;
}
