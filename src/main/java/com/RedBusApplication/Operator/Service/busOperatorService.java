package com.RedBusApplication.Operator.Service;

import com.RedBusApplication.Operator.payload.BusOperatorDTO;

import java.util.Date;
import java.util.List;

public interface busOperatorService {
    BusOperatorDTO ScheduleBus(BusOperatorDTO busOperatorDTO);

    List<BusOperatorDTO> getAllBusses();

    BusOperatorDTO getBusByBusId(String busId);

    BusOperatorDTO getBusByBusNumber(int busNum);

    List<BusOperatorDTO> findBusByBusType(String busType);

    BusOperatorDTO findByBusDriverName(String busDriver);

//    List<BusOperatorDTO> findByDepartureDate(Date departureDate);
//
    List<BusOperatorDTO> findByOperatorName(String operator);
}
