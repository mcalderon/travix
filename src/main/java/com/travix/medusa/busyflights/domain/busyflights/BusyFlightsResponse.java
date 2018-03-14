package com.travix.medusa.busyflights.domain.busyflights;

import java.util.List;

import com.travix.medusa.busyflights.engine.entity.BusyFlight;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusyFlightsResponse {

    private List<BusyFlight> busyFlightList;
}
