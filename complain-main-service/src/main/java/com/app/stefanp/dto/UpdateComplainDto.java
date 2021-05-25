package com.app.stefanp.dto;

import com.app.stefanp.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateComplainDto
{
    private Long number;
    private String title;
    private String description;

    private Long userId;
    private Status status;

}
