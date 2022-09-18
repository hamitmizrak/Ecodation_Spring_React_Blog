package com.hamitmizrak.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//lombok
@Data

//Entity
@Entity
@Table(name="blog_register")
public class BlogRegisterEntity extends BaseEntity{

@Column(name="user_name")
    private String username;

    @Column(name="user_email")
    private String email;

    @Column(name="user_password",columnDefinition = "varchar(255) default 'Hm1234@'")
    private String password;
}
