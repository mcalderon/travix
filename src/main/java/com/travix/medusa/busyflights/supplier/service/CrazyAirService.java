package com.travix.medusa.busyflights.supplier.service;

import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirResponse;


public interface CrazyAirService {

    CrazyAirResponse getAllFlights();
    CrazyAirResponse searchWithCriteria(CrazyAirRequest request);

}
