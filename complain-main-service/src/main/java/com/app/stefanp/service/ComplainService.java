package com.app.stefanp.service;

import com.app.stefanp.dto.ChangeStatusDto;
import com.app.stefanp.dto.CreateComplainDto;
import com.app.stefanp.dto.GetComplainDto;
import com.app.stefanp.dto.UpdateComplainDto;
import com.app.stefanp.dto.mappers.Mapper;
import com.app.stefanp.exceptions.AppException;
import com.app.stefanp.repository.ComplainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ComplainService
{
    private final ComplainRepository complainRepository;



    public Long addComplain(CreateComplainDto createComplainDto)
    {
        if (Objects.isNull(createComplainDto))
        {
            throw new AppException("CREATE COMPLAIN DTO ARGUMENT IS NULL");
        }

        var complain = Mapper.fromCreateToComplain(createComplainDto);
        return complainRepository.save(complain).getId();
    }

    public List<GetComplainDto> getAllComplains()
    {
        return complainRepository
                .findAll()
                .stream()
                .map(Mapper::fromComplainToGet)
                .collect(Collectors.toList());
    }

    public GetComplainDto getOneComplain(Long id)
    {
        if (Objects.isNull(id))
        {
            throw new AppException("ID ARGUMENT IS NULL");
        }

        return complainRepository
                .findById(id)
                .map(Mapper::fromComplainToGet)
                .orElseThrow(() -> new AppException("CANNOT FIND COMPLAIN WITH ID: " + id));
    }

    public Long deleteOneComplain(Long id)
    {
        if (Objects.isNull(id))
        {
            throw new AppException("ID ARGUMENT IS NULL");
        }

        var complain = complainRepository
                .findById(id)
                .orElseThrow(() -> new AppException("CANNOT FIND COMPLAIN WITH ID: " + id));

        complainRepository.deleteById(id);
        return complain.getId();
    }

    // =========================================================================================================================================================
    // FULL UPDATE - CHANGE DESCRIPTION, TITLE
    public Long updateComplainByUser(Long id, UpdateComplainDto updateComplainDto)
    {
        if (Objects.isNull(id))
        {
            throw new AppException("ID ARGUMENT IS NULL");
        }

        if (Objects.isNull(updateComplainDto))
        {
            throw new AppException("ARGUMENT UPDATE COMPLAIN DTO IS NULL");
        }

        var complainToUpdate = complainRepository
                .findById(id)
                .orElseThrow(() -> new AppException("CANNOT FIND COMPLAIN WITH ID: " + id));

        System.out.println("------------------------------------- ID ---------------------------------------");
        System.out.println(complainToUpdate.getId());

        complainToUpdate.setDescription(updateComplainDto.getDescription());
        complainToUpdate.setTitle(updateComplainDto.getTitle());
        return complainToUpdate.getId();
    }

    // PARTIAL UPDATE - CHANGE STATUS =========================================================================================================================
    public Long updateComplainByAdmin(Long id, UpdateComplainDto updateComplainDto)
    {
        if (Objects.isNull(id))
        {
            throw new AppException("ID ARGUMENT IS NULL");
        }

        if (Objects.isNull(updateComplainDto))
        {
            throw new AppException("ARGUMENT UPDATE COMPLAIN DTO IS NULL");
        }

        var complainToUpdate = complainRepository
                .findById(id)
                .orElseThrow(() -> new AppException("CANNOT FIND COMPLAIN WITH ID: " + id));

        complainToUpdate.setNumber(updateComplainDto.getNumber());
        complainToUpdate.setStatus(updateComplainDto.getStatus());

        return complainToUpdate.getId();
    }


    public Long changeStatus(Long id, ChangeStatusDto changeStatusDto)
    {
        if (Objects.isNull(id))
        {
            throw new AppException("ID IS NULL");
        }

        if (Objects.isNull(changeStatusDto))
        {
            throw new AppException("changeStatusDto ARGUMENT IS NULL");
        }

        var complain = complainRepository
                .findById(id)
                .orElseThrow(() -> new AppException("CANNOT FIND COMPLAIN WITH ID: " + id));

        complain.setStatus(changeStatusDto.getStatus());
        return complain.getId();
    }



}












