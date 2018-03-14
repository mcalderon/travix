package com.travix.medusa.busyflights.controller.supplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.supplier.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.supplier.service.ToughJetService;

@RestController
@RequestMapping("/toughjet")
public class ToughJetController {

    @Autowired
    private ToughJetService toughJetService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ToughJetResponse searchFlights(@Valid ToughJetRequest request) {
        return this.toughJetService.searchWithCriteria(request);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ToughJetResponse listAllFlights() {
        return this.toughJetService.getAllFlights();
    }
}
