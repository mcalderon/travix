package com.travix.medusa.busyflights.supplier.service;


import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetResponse;

public interface ToughJetService {

    ToughJetResponse getAllFlights();
    ToughJetResponse searchWithCriteria(ToughJetRequest request);

}
