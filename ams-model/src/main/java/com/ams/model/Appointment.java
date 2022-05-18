package com.ams.model;

/**
 * @author: Anwar.Badr
 */

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="appointment")
@Data
public class Appointment extends BaseEntity<Integer> {

    @Column(name="appointment_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name="is_canceled")
    private Boolean isCanceled;

    @Column(name="cancel_reason")
    private String cancelReason;
}
