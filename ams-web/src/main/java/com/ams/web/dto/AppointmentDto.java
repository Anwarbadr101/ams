package com.ams.web.dto;

/**
 * @author: Anwar.Badr
 */

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class AppointmentDto extends BaseDto<Integer> {

    private Date date;
    private Boolean isCanceled;
    private String cancelReason;
    private PatientDto patient;
}
