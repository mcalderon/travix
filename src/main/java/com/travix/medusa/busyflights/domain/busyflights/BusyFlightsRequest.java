package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusyFlightsRequest {

    @NotNull(message = "Origin parameter is missing")
    @Size(min = 3, max = 3, message = "Origin must be a 3 letter IATA code")
    private String origin;
    @NotNull(message = "Destination parameter is missing")
    @Size(min = 3, max = 3, message = "Destination must be a 3 letter IATA code")
    private String destination;
    @NotNull(message = "Departure date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String departureDate;
    @NotNull(message = "Return date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String returnDate;
    @NotNull(message = "Number of passengers is missing")
    @Min(value = 1)
    @Max(value = 4)
    private String numberOfPassengers;
}
