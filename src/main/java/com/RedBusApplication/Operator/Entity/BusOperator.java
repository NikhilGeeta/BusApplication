package com.RedBusApplication.Operator.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusOperator {
    @Id
    private String busId;

    private int busNumber;
    private String busOperator;
    private String driverName;
    private String numberOfSeats;
    private String departureCity;
    private String arrivalCity;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalTime departureTime;
    private int totalTravelTime;
    private String busType;
    private String animeties;


}
