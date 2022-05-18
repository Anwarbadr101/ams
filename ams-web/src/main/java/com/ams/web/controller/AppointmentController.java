package com.ams.web.controller;

import com.ams.model.Appointment;
import com.ams.model.exception.BusinessException;
import com.ams.service.AppointmentService;
import com.ams.web.dto.AppointmentDto;
import com.ams.web.mapper.AppointmentMapper;
import com.ams.web.response.SuccessResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: Anwar.Badr
 */
@RestController
@RequestMapping("/appointment")
@Api(value="rooms", description = "Data service operations on clinic appointments ", tags=("appointments"))
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @Autowired
    private AppointmentMapper appointmentMapper;


    @GetMapping(value = "/getAllToday")
    @ApiOperation(value="Get All today appointments", notes="Gets all today appointments in the system", nickname="getAllToday")
    public SuccessResponse<List<AppointmentDto>> getAllToday() throws BusinessException {
        return new SuccessResponse<>(appointmentMapper.mapList(appointmentService.getAllToday()));
    }

    @PostMapping(value = "/add")
    @ApiOperation(value="add new appointment for patient", notes="save ne appointment for patient in the system", nickname="addAppointment")
    public SuccessResponse<AppointmentDto> add(@RequestBody AppointmentDto appointmentDto) throws BusinessException {
        Appointment appointment = appointmentMapper.unMap(appointmentDto);
        return new SuccessResponse<>(appointmentMapper.map(appointmentService.addAppointment(appointment)));
    }

    @PutMapping(value = "/{id}/cancel")
    @ApiOperation(value="cancel an appointment by appointment id ", notes="cancel an appointment by appointment id", nickname="/{id}/cancel")
    public SuccessResponse<AppointmentDto> cancel(@PathVariable Integer id,@RequestBody String cancelReason) throws BusinessException {
        Appointment appointment = appointmentService.cancelAppointment(appointmentService.getById(id),cancelReason);
        return new SuccessResponse<>(appointmentMapper.map(appointment));
    }

    @GetMapping(value = "/getAllByDate")
    @ApiOperation(value="Get All appointments for specific date ", notes="Gets all appointments for specific date in the system", nickname="getAllByDate")
    public SuccessResponse<List<AppointmentDto>> getByDate(@RequestParam(name="appointmentDate") Date appointmentDate) throws BusinessException {
       return new SuccessResponse<>(appointmentMapper.mapList(appointmentService.getAllByDate(appointmentDate)));
    }

    @GetMapping(value = "/getByPatientName")
    @ApiOperation(value="Get All appointments by patient name ", notes="Gets all future and history appointments by patient name in the system", nickname="getByPatientName")
    public SuccessResponse<List<AppointmentDto>> getByPatientName(@RequestParam(name="patientName") String patientName) throws BusinessException {
        return new SuccessResponse<>(appointmentMapper.mapList(appointmentService.getAllByPatientName(patientName)));
    }

    @GetMapping(value = "patient/{id}/hisory")
    @ApiOperation(value="Get All patient appointments history", notes="Gets all patient appointments history in the system", nickname="patient/{patientId}/hisory")
    public SuccessResponse<List<AppointmentDto>> getPatient(@PathVariable(name="id") Integer id) throws BusinessException {
        return new SuccessResponse<>(appointmentMapper.mapList(appointmentService.getPatientAppointmentHistory(id)));
    }
    
}
