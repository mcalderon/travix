package com.travix.medusa.busyflights.engine.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.engine.entity.BusyFlight;
import com.travix.medusa.busyflights.engine.search.SupplierSearch;
import com.travix.medusa.busyflights.engine.search.supplier.CrazyAirSearch;
import com.travix.medusa.busyflights.engine.search.supplier.ToughJetSearch;

@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

    @Override
    public BusyFlightsResponse searchForFlights(BusyFlightsRequest request) {
        List<SupplierSearch> searchList = Arrays.asList(
            new CrazyAirSearch(),
            new ToughJetSearch()
        );
        return new BusyFlightsResponse(
            searchList
                .stream()
                .map(supplier -> supplier.search(request))
                .flatMap(list -> list.getBusyFlightList().stream())
                .sorted(Comparator.comparingDouble(BusyFlight::getFare))
                .collect(Collectors.toList())
        );
    }
}
