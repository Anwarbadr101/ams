package com.ams.repository;

import com.ams.model.Patient;
import org.springframework.stereotype.Repository;

/**
 * @author: Anwar.Badr
 */
@Repository
public interface PatientRepository extends BaseRepository<Patient, Integer> {
}
