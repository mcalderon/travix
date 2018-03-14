package com.travix.medusa.busyflights.domain.supplier.toughjet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToughJetRequest {

    @NotNull(message = "From parameter is missing")
    @Size(min = 3, max = 3, message = "Origin must be a 3 letter IATA code")
    private String from;
    @NotNull(message = "To parameter is missing")
    @Size(min = 3, max = 3, message = "Destination must be a 3 letter IATA code")
    private String to;
    @NotNull(message = "Outbound date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String outboundDate;
    @NotNull(message = "Inbound date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String inboundDate;
    @NotNull(message = "Number of adults is missing")
    private String numberOfAdults;
}
