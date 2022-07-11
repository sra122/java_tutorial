package com.sravan.jpa.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
@Getter
@Setter
public abstract class Abstract
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Date createdDate;

    private Date modifiedDate;

    @ColumnDefault("false")
    private Boolean isDeleted;
}
