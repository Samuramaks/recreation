package ru.stanok.recreation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import ru.stanok.recreation.dto.DepartureDTO;
import ru.stanok.recreation.entity.Departure;
import ru.stanok.recreation.service.DepartureServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@RestController
public class ControllerAdmin {

    @Autowired
    DepartureServiceInterface departureServiceInterface;

    @PostMapping("/add")
    public ResponseEntity<DepartureDTO> addDeparture(@RequestBody DepartureDTO departureDTO) {
        Departure departure = new Departure();
        departure.setCity(departureDTO.getCity());
        departure.setDateArrival(departureDTO.getDateArrival());
        departure.setDateDeparture(departureDTO.getDateDeparture());
        departureServiceInterface.addDeparture(departure);
        log.info("add entity: " + departureDTO);
        return ResponseEntity.ok().build();
    }
    
    
}
