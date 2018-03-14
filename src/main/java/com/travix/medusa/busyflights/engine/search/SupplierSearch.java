package com.travix.medusa.busyflights.engine.search;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.engine.properties.DefaultEngineProperties;
import com.travix.medusa.busyflights.engine.properties.EngineProperties;

public abstract class SupplierSearch<K> {

    private EngineProperties engineProperties;

    protected String getSupplierUrl(String key) {
        this.engineProperties = new DefaultEngineProperties();
        return this.engineProperties.getProperty(key);
    }

    protected <T> T searchSupplier(String url, Class<T> responseType, Map<String, String> params) {
        return new RestTemplate().getForObject(url, responseType, params);
    }

    protected Map<String, String> getSupplierParameters(BusyFlightsRequest request) {
        Map<String, String> params = new HashMap<>();
        params.put("from", request.getOrigin());
        params.put("to", request.getDestination());
        params.put("start", request.getDepartureDate());
        params.put("end", request.getReturnDate());
        params.put("count", request.getNumberOfPassengers());
        return params;
    }

    public abstract BusyFlightsResponse search(BusyFlightsRequest request);

    protected abstract K calculateTotalPrice(K flight, int totalPax);
}
