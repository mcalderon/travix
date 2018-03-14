package com.travix.medusa.busyflights.engine.search.supplier;

import java.util.Map;
import java.util.stream.Collectors;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.engine.entity.BusyFlight;
import com.travix.medusa.busyflights.engine.search.SupplierSearch;
import com.travix.medusa.busyflights.engine.search.Transformer;
import com.travix.medusa.busyflights.supplier.entity.ToughJet;

public class ToughJetSearch extends SupplierSearch<ToughJet> implements Transformer<ToughJetResponse> {

    @Override
    public BusyFlightsResponse search(BusyFlightsRequest request) {
        String serviceUrl = this.getSupplierUrl("toughjet.url");
        Map<String, String> params = this.getSupplierParameters(request);
        ToughJetResponse response = this.searchSupplier(serviceUrl, ToughJetResponse.class, params);
        response.setToughJetList(
            response.getToughJetList().stream()
                    .map(flight -> this.calculateTotalPrice(
                        flight, Integer.valueOf(request.getNumberOfPassengers())
                    ))
                    .collect(Collectors.toList())
        );
        return this.toBusyFlightsResponse(response);
    }

    @Override
    protected ToughJet calculateTotalPrice(ToughJet flight, int totalPax) {
        final double price = (
            (flight.getBasePrice() * totalPax) * (flight.getDiscount() / 100)
        ) * flight.getTax();
        flight.setBasePrice(Math.floor(price * 100) / 100);
        return flight;
    }

    @Override
    public BusyFlightsResponse toBusyFlightsResponse(ToughJetResponse supplierResponse) {
        return new BusyFlightsResponse(supplierResponse
               .getToughJetList()
               .stream()
               .map(flight ->
                        new BusyFlight(
                            flight.getCarrier(),
                            "ToughJet",
                            flight.getBasePrice(),
                            flight.getDepartureAirportName(),
                            flight.getArrivalAirportName(),
                            flight.getOutboundDateTime(),
                            flight.getInboundDateTime()
                        )
               ).collect(Collectors.toList()));
    }

}
