package com.app.stefanp.repository;

import com.app.stefanp.dto.ChangeStatusDto;
import com.app.stefanp.model.Complain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplainRepository extends JpaRepository<Complain, Long>
{
//    Optional<Complain> findByNumber(Long number);
//    Optional<Complain> findByTitle(String title);
//    Optional<Complain> findByUserId(Long id);

}
