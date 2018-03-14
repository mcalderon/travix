package com.travix.medusa.busyflights.controller.busyflights;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.engine.service.BusyFlightsService;

@RestController
@RequestMapping("/busyflights")
public class BusyFlightsController {

    @Autowired
    private BusyFlightsService busyFlightsService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public BusyFlightsResponse findFlights(@Valid BusyFlightsRequest request) {
        return this.busyFlightsService.searchForFlights(request);
    }
}
