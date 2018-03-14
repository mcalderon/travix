package com.travix.medusa.busyflights.engine.search;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface Transformer<T> {

    BusyFlightsResponse toBusyFlightsResponse(T supplierResponse);
}
