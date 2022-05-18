package com.ams.service;

import com.ams.model.Appointment;

import java.util.Date;
import java.util.List;

/**
 * @author: Anwar.Badr
 */
public interface AppointmentService extends BaseService<Appointment, Integer> {
    Appointment getById(Integer id);
    List<Appointment> getAllToday();
    Appointment addAppointment(Appointment appointment);

    Appointment cancelAppointment(Appointment appointment,String cancelReason);

    List<Appointment> getAllByDate(Date date);
    List<Appointment> getAllByPatientName(String patientName);

    List<Appointment> getPatientAppointmentHistory(Integer patientId);
}
