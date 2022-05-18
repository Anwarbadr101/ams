package com.ams.web.mapper;

import com.ams.model.Patient;
import com.ams.web.dto.PatientDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: Anwar.Badr
 */
@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDto map(Patient patient);

    Patient unMap(PatientDto patientDto);

    List<PatientDto> mapList(List<Patient> patients);

    List<Patient> unMapList(List<PatientDto> patientDtos);
}
