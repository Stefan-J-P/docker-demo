package com.app.stefanp.dto.mappers;

import com.app.stefanp.dto.CreateComplainDto;
import com.app.stefanp.dto.GetComplainDto;
import com.app.stefanp.model.Complain;

import java.util.Objects;

public interface Mapper
{

    static Complain fromCreateToComplain(CreateComplainDto createComplainDto)
    {
        return Objects.isNull(createComplainDto) ? null : Complain
                .builder()
                .id(createComplainDto.getUserId())
                .number(createComplainDto.getNumber())
                .title(createComplainDto.getTitle())
                .description(createComplainDto.getDescription())
                .status(createComplainDto.getStatus())
                .build();
    }


    static GetComplainDto fromComplainToGet(Complain complain)
    {
        return Objects.isNull((complain)) ? null : GetComplainDto
                .builder()
                .id(complain.getId())
                .number(complain.getNumber())
                .title(complain.getTitle())
                .description(complain.getDescription())
                .status(complain.getStatus())
                .build();
    }






}
