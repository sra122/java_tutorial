package com.sravan.jpa.model;

import com.sravan.jpa.request.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends Abstract
{
    @Column(unique = true, nullable = false)
    private String LicencePlate;

    private String Model;

    private String Brand;

    private Float Millage;

    private String color;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus = CarStatus.FREE;

}
