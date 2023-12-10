package com.RedBusApplication.Operator.ServiceImpl;

import com.RedBusApplication.Operator.Entity.BusOperator;
import com.RedBusApplication.Operator.Exception.SourceNotFoundException;
import com.RedBusApplication.Operator.Repository.BusOperatorRepository;
import com.RedBusApplication.Operator.Service.busOperatorService;
import com.RedBusApplication.Operator.payload.BusOperatorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class busOperatorServiceImpl implements busOperatorService {
    @Autowired
    private BusOperatorRepository busOperatorRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public BusOperatorDTO ScheduleBus(BusOperatorDTO busOperatorDTO) {
        BusOperator busOperator = mapToEntity(busOperatorDTO);
        String Id = UUID.randomUUID().toString();
        busOperator.setBusId(Id);
        System.out.println(busOperator);
        BusOperator savedOperator = busOperatorRepo.save(busOperator);

        return mapToDto(savedOperator);
    }

    @Override
    public List<BusOperatorDTO> getAllBusses() {
        List<BusOperator> all = busOperatorRepo.findAll();

        return all.stream().map(this::mapToDto).collect(Collectors.toList());
    }


    @Override
    public BusOperatorDTO getBusByBusId(String busId) {

        BusOperator busOperator = busOperatorRepo.findByBusId(busId).orElseThrow(
                () -> new SourceNotFoundException("NO bus found with these id")
        );
        return mapToDto(busOperator);
    }

    @Override
    public BusOperatorDTO getBusByBusNumber(int busNum) {
        BusOperator byBusNumber = busOperatorRepo.findByBusNumber(busNum);
        return mapToDto(byBusNumber);
    }

    @Override
    public List<BusOperatorDTO> findBusByBusType(String busType) {
        List<BusOperator> busOperators = busOperatorRepo.findByBusType(busType);
        return busOperators.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public BusOperatorDTO findByBusDriverName(String busDriver) {
        BusOperator byDriverName = busOperatorRepo.findByDriverName(busDriver);
        return mapToDto(byDriverName);
    }

//    @Override
//    public List<BusOperatorDTO> findByDepartureDate(Date departureDate) {
//        List<BusOperator> byDepartureDate = busOperatorRepo.findByDepartureDate(departureDate);
//
//        return byDepartureDate.stream().map(this::mapToDto).collect(Collectors.toList());
//    }
    @Override
    public List<BusOperatorDTO> findByOperatorName(String operator) {
        List<BusOperator> byBusOperator = busOperatorRepo.findByBusOperator(operator);
        return byBusOperator.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    BusOperator mapToEntity(BusOperatorDTO busOperatorDTO){
        return mapper.map(busOperatorDTO, BusOperator.class);
    }

    BusOperatorDTO mapToDto(BusOperator busOperator){
        return mapper.map(busOperator, BusOperatorDTO.class);
    }
}
