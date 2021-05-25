package com.app.stefanp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "complain")
public class Complain
{
    @Id
    @GeneratedValue
    private Long id;

    private Long number;
    private String title;
    private String description;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private Status status;

}
