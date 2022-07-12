package com.sravan.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@MappedSuperclass
@Getter
@Setter
public abstract class Abstract implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private long createdDate;

    private long modifiedDate = Instant.now().toEpochMilli();

    @Column(nullable = false)
    private Boolean isDeleted = false;
}
