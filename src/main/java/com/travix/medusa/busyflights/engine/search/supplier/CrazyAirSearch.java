package com.travix.medusa.busyflights.engine.search.supplier;

import java.util.Map;
import java.util.stream.Collectors;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.engine.entity.BusyFlight;
import com.travix.medusa.busyflights.engine.search.SupplierSearch;
import com.travix.medusa.busyflights.engine.search.Transformer;
import com.travix.medusa.busyflights.supplier.entity.CrazyAir;

public class CrazyAirSearch extends SupplierSearch<CrazyAir> implements Transformer<CrazyAirResponse> {

    @Override
    public BusyFlightsResponse search(BusyFlightsRequest request) {
        String serviceUrl = this.getSupplierUrl("crazyair.url");
        Map<String, String> params = this.getSupplierParameters(request);
        CrazyAirResponse response = this.searchSupplier(serviceUrl, CrazyAirResponse.class, params);
        response.setCrazyAirList(
            response.getCrazyAirList().stream()
                    .map(flight -> this.calculateTotalPrice(flight, Integer.valueOf(request.getNumberOfPassengers())))
                    .collect(Collectors.toList())
        );
        return this.toBusyFlightsResponse(response);
    }

    @Override
    protected CrazyAir calculateTotalPrice(CrazyAir flight, int totalPax) {
        flight.setPrice(Math.floor((flight.getPrice() * totalPax) * 100) / 100);
        return flight;
    }

    @Override
    public BusyFlightsResponse toBusyFlightsResponse(CrazyAirResponse supplierResponse) {
        return new BusyFlightsResponse(supplierResponse
            .getCrazyAirList()
            .stream()
            .map(flight ->
                     new BusyFlight(
                         flight.getAirline(),
                         "CrazyAir",
                         flight.getPrice(),
                         flight.getDepartureAirportCode(),
                         flight.getDestinationAirportCode(),
                         flight.getDepartureDate(),
                         flight.getArrivalDate()
                     )
            ).collect(Collectors.toList()));
    }
}
