package com.travix.medusa.busyflights.supplier.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.supplier.entity.ToughJet;
import com.travix.medusa.busyflights.utils.DataLoader;
import com.travix.medusa.busyflights.utils.DateUtils;

@Service
public class ToughJetServiceImpl implements  ToughJetService {

    private List<ToughJet> flights = new ArrayList<>();

    public ToughJetServiceImpl() {
        flights = DataLoader.loadCsvData(ToughJet.class, "assets/flightdata/toughjet.csv");
    }

    @Override
    public ToughJetResponse getAllFlights() {
        return new ToughJetResponse(flights);
    }

    @Override
    public ToughJetResponse searchWithCriteria(ToughJetRequest request) {
        return new ToughJetResponse(flights.stream()
            .filter(result -> result.getDepartureAirportName().equals(request.getFrom()))
            .filter(result -> result.getArrivalAirportName().equals(request.getTo()))
            .filter(result -> DateUtils.areDatesEqual(result.getInboundDateTime(), request.getInboundDate()))
            .filter(result -> DateUtils.areDatesEqual(result.getOutboundDateTime(), request.getOutboundDate()))
            .collect(Collectors.toList()));
    }
}
