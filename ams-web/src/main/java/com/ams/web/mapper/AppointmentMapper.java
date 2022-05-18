package com.ams.web.mapper;

import com.ams.model.Appointment;
import com.ams.web.dto.AppointmentDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: Anwar.Badr
 */
@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentDto map(Appointment appointment);

    Appointment unMap(AppointmentDto appointmentDto);

    List<AppointmentDto> mapList(List<Appointment> appointments);

    List<Appointment> unMapList(List<AppointmentDto> appointmentDtos);
}
