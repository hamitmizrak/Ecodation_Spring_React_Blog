package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.BlogRegisterEntity;
import com.hamitmizrak.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    //Find Email
    EmployeeEntity findByEmail(String email);
}
