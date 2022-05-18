package com.ams.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: Anwar.Badr
 */
@Entity
@Table(name="patient")
@Data
public class Patient extends BaseEntity<Integer> {

    @Column(name="name")
    private String name;

}
