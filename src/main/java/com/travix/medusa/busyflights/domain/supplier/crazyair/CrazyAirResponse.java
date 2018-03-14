package com.travix.medusa.busyflights.domain.supplier.crazyair;

import java.util.List;


import com.travix.medusa.busyflights.supplier.entity.CrazyAir;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CrazyAirResponse {

    private List<CrazyAir> crazyAirList;
}
