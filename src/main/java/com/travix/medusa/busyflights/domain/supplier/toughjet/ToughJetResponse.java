package com.travix.medusa.busyflights.domain.supplier.toughjet;

import java.util.List;

import com.travix.medusa.busyflights.supplier.entity.ToughJet;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ToughJetResponse {

    private List<ToughJet> toughJetList;

}
