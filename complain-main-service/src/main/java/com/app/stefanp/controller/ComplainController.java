package com.app.stefanp.controller;

import com.app.stefanp.dto.*;
import com.app.stefanp.repository.ComplainRepository;
import com.app.stefanp.service.ComplainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complains")
public class ComplainController
{
    private final ComplainService complainService;

    @PostMapping
    public ResponseData<Long> addNewComplain(@RequestBody CreateComplainDto createComplainDto)
    {
        return ResponseData
                .<Long>builder()
                .data(complainService.addComplain(createComplainDto))
                .build();

    }

    @GetMapping
    public ResponseData<List<GetComplainDto>> findAllComplains()
    {
        return ResponseData
                .<List<GetComplainDto>>builder()
                .data(complainService.getAllComplains())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseData<GetComplainDto> findOneComplainById(@PathVariable Long id)
    {
        return ResponseData
                .<GetComplainDto>builder()
                .data(complainService.getOneComplain(id))
                .build();
    }


    @DeleteMapping("/{id}")
    public ResponseData<Long> deleteOneComplainById(@PathVariable Long id)
    {
        return ResponseData.<Long>builder()
                .data(complainService.deleteOneComplain(id))
                .build();
    }

    @PutMapping("/user/{id}")
    public ResponseData<Long> updateByUser(@PathVariable Long id, @RequestBody UpdateComplainDto updateComplainDto)
    {
        System.out.println("*************************************************************************************");
        return ResponseData
                .<Long>builder()
                .data(complainService.updateComplainByUser(id, updateComplainDto))
                .build();
    }

    @PutMapping("/admin/{id}")
    public ResponseData<Long> updateByAdmin(@PathVariable Long id, @RequestBody UpdateComplainDto updateComplainDto)
    {
        return ResponseData.<Long>builder()
                .data(complainService.updateComplainByAdmin(id, updateComplainDto))
                .build();
    }

    @PatchMapping("/admin/staus/{id}")
    public ResponseData<Long> changeStatus(@PathVariable Long id, @RequestBody ChangeStatusDto changeStatusDto)
    {
        return ResponseData
                .<Long>builder()
                .data(complainService.changeStatus(id, changeStatusDto))
                .build();
    }


}













