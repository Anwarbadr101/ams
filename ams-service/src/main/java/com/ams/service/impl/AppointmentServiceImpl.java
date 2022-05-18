package com.ams.service.impl;

import com.ams.model.Appointment;
import com.ams.model.exception.BusinessException;
import com.ams.repository.AppointmentRepository;
import com.ams.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: Anwar.Badr
 */
@Service
@Transactional
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, Integer>
        implements AppointmentService {


    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllToday() {
        return appointmentRepository.findByDate(new Date());
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment cancelAppointment(Appointment appointment, String cancelReason) {
        appointment.setIsCanceled(true);
        appointment.setCancelReason(cancelReason);
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllByDate(Date date) {
        return appointmentRepository.findByDate(date);
    }

    @Override
    public List<Appointment> getAllByPatientName(String patientName) {
        return appointmentRepository.findByPatientName(patientName);
    }

    @Override
    public List<Appointment> getPatientAppointmentHistory(Integer patientId) {
        return appointmentRepository.findByPatientIdAndHistoryDate(patientId,new Date());
    }

    @Override
    public Appointment getById(Integer id){
        return appointmentRepository.findById(id).orElseThrow(() -> new BusinessException());
    }
}
