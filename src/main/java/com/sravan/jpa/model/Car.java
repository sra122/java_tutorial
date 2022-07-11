package com.sravan.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends Abstract
{
    @Column(unique = true)
    private String LicencePlate;

    private String Model;

    private String Brand;

    private Float Millage;

    private String color;
}
