package ru.stanok.recreation.dto;

import lombok.Data;
import ru.stanok.recreation.entity.Departure;

import java.time.LocalDate;

@Data
public class DepartureDTO {
    private long id;
    private LocalDate dateDeparture;
    private LocalDate dateArrival;
    private String city;

    

    public static DepartureDTO from(Departure departure) {
        DepartureDTO departureDTO = new DepartureDTO();
        departureDTO.setId(departure.getId());
        departureDTO.setDateDeparture(departure.getDateDeparture());
        departureDTO.setDateArrival(departure.getDateArrival());
        departureDTO.setCity(departure.getCity());

        return departureDTO;
    }

    public Departure toDeparture(){
        Departure departure = new Departure();

        departure.setId(this.id);
        departure.setDateArrival(this.dateArrival);
        departure.setDateDeparture(this.dateDeparture);
        departure.setCity(this.city);

        return departure;
    }
}
