package com.travix.medusa.busyflights.supplier.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.supplier.entity.CrazyAir;
import com.travix.medusa.busyflights.utils.DataLoader;
import com.travix.medusa.busyflights.utils.DateUtils;

@Service
public class CrazyAirServiceImpl implements CrazyAirService {

    private List<CrazyAir> flights = new ArrayList<>();

    public CrazyAirServiceImpl() {
        flights = DataLoader.loadCsvData(CrazyAir.class, "assets/flightdata/crazyair.csv");
    }

    @Override
    public CrazyAirResponse getAllFlights() {
        return new CrazyAirResponse(flights);
    }

    @Override
    public CrazyAirResponse searchWithCriteria(CrazyAirRequest request) {
        return new CrazyAirResponse(flights.stream()
            .filter(result -> result.getDepartureAirportCode().equals(request.getOrigin()))
            .filter(result -> result.getDestinationAirportCode().equals(request.getDestination()))
            .filter(result -> DateUtils.areDatesEqual(result.getDepartureDate(), request.getDepartureDate()))
            .filter(result -> DateUtils.areDatesEqual(result.getArrivalDate(), request.getReturnDate()))
            .collect(Collectors.toList()));
    }
}
