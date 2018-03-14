package com.travix.medusa.busyflights.engine.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface BusyFlightsService {

    BusyFlightsResponse searchForFlights(BusyFlightsRequest request);
}
