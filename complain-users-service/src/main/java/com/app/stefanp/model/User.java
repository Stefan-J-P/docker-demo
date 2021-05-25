package com.app.stefanp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @ElementCollection
    @CollectionTable(name = "complains")
    private List<Long> complains;

    @Enumerated(EnumType.STRING)
    private Role role;
}
