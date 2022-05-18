package com.ams.repository.test;


import com.ams.model.Appointment;
import com.ams.model.Patient;
import com.ams.repository.PatientRepository;
import com.ams.repository.AppointmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @author: Anwar.Badr
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Transactional
//@Rollback(false)
@DisplayName("<= AppointmentRepositoryTests =>")
class AppointmentRepositoryTests {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

	@BeforeEach
	void init() {
		Assertions.assertNotNull(appointmentRepository);
        Assertions.assertNotNull(patientRepository);
	}

    @Test
	@DisplayName("saves a new entity Appointment")
	 void testSave() {
        Patient patient = new Patient();
        patient.setName("test");

        patient = patientRepository.save(patient);

        Appointment appointment = new Appointment();
        appointment.setId(1);

        appointment = appointmentRepository.save(appointment);
		Assertions.assertNotNull(appointment.getId());
	}

    @Test
    @DisplayName("saves already exist Appointment")
    void testSaveAlreadyExist() {
        Patient patient = new Patient();
        patient.setId(1);

        Appointment appointment = new Appointment();
        appointment.setId(1);

        appointment.setPatient(patient);

        appointment = appointmentRepository.save(appointment);
        Assertions.assertNotNull(appointment.getId());
    }
}
