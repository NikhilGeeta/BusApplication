package com.RedBusApplication.Operator.payload;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusOperatorDTO {

    private String busId;
    private int busNumber;
    private String busOperator;
    private String driverName;
    private String numberOfSeats;
    private String departureCity;
    private String arrivalCity;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate arrivalDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate departureDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime departureTime;
    private int totalTravelTime;
    private String busType;
    private String animeties;

}
