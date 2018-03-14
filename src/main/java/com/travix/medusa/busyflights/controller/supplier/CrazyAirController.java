package com.travix.medusa.busyflights.controller.supplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.supplier.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.supplier.service.CrazyAirService;

@RestController
@RequestMapping("/crazyair")
public class CrazyAirController {

    @Autowired
    private CrazyAirService crazyAirService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public CrazyAirResponse searchFlights(@Valid CrazyAirRequest request) {
        return this.crazyAirService.searchWithCriteria(request);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CrazyAirResponse listAllFlights() {
        return this.crazyAirService.getAllFlights();
    }
}
