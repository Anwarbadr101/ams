package com.ams.repository;

import com.ams.model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author: Anwar.Badr
 */
@Repository
public interface AppointmentRepository extends BaseRepository<Appointment, Integer> {

    @Query("select a from Appointment a where a.date = :date")
    List<Appointment> findByDate(Date date);

    List<Appointment> findByPatientName(String  patientName);

    @Query("select a from Appointment a where a.patient.id=:id and a.date <= :date")
    List<Appointment> findByPatientIdAndHistoryDate(Integer  id, Date date);
}
