package com.hamitmizrak.data.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//lombok
@Data
@NoArgsConstructor
@Builder

//entity
@Entity
@Table(name = "employees")
public class EmployeeEntity  extends BaseEntity {

    @Column(name="employee_name")
    public String name;

    @Column(name="employee_email")
    public String email;

    //parametreli constructor
    public EmployeeEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
