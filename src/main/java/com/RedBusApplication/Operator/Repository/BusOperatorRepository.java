package com.RedBusApplication.Operator.Repository;

import com.RedBusApplication.Operator.Entity.BusOperator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@EnableAutoConfiguration
public interface BusOperatorRepository extends JpaRepository<BusOperator,String> {
    BusOperator findByBusNumber(int busNum);
   List<BusOperator> findByBusType(String busType);

    BusOperator findByDriverName(String busDriver);

    //List<BusOperator> findByDepartureDate(Date departureDate);

    List<BusOperator> findByBusOperator(String operator);

    Optional<BusOperator> findByBusId(String busId);
}
