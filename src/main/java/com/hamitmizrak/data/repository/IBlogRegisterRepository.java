package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.BlogRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRegisterRepository extends JpaRepository<BlogRegisterEntity,Long > {

    //Find Email
    BlogRegisterEntity findByEmail(String email);
}
