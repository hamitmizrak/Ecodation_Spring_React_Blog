package com.hamitmizrak.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//lombok
@Getter @Setter

//BaseEntity
@MappedSuperclass

//Auditing
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"created_date","updated_date"})
abstract   public class BaseEntity {

    //object variable
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,updatable = false)
    private Long id;

    //Kim ekledi ?
    @CreatedBy
    @Column (name = "created_by")
    public String createdBy;

    //ne zaman ekledi ?
    @CreatedDate
    @Column (name = "created_date")
    public Date createdDate;

    //Kim Güncelledi ?
    @Column (name = "updated_by")
    @LastModifiedBy
    public String updatedBy;

    //ne zaman güncellendi ?
    @Column (name = "updated_date")
    @LastModifiedDate
    public Date updatedDate;

    @Column (name = "now_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date nowDate;

    //ne zaman ekledi ?
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "system_created_date")
    public Date systemCreatedDate;
}
