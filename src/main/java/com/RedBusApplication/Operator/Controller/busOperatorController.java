package com.RedBusApplication.Operator.Controller;

import com.RedBusApplication.Operator.Service.busOperatorService;
import com.RedBusApplication.Operator.payload.BusOperatorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bus-operator")
public class busOperatorController {

    @Autowired
    private busOperatorService busService;

    // http://localhost:8080/api/bus-operator
    @PostMapping
    public ResponseEntity<BusOperatorDTO> ScheduleBus(@RequestBody BusOperatorDTO busOperatorDTO) {
        BusOperatorDTO savedBusOperatorDto = busService.ScheduleBus(busOperatorDTO);
        return new ResponseEntity<>(savedBusOperatorDto, HttpStatus.CREATED);
    }


    // http://localhost:8080/api/bus-operator
    @GetMapping
    public ResponseEntity<List<BusOperatorDTO>> getAllBusDetails() {
        List<BusOperatorDTO> allBusses = busService.getAllBusses();
        return new ResponseEntity<>(allBusses, HttpStatus.OK);
    }

    // get by bus Id ; http://localhost:8080/api/bus-operator/{busId}
    @GetMapping("/bus/{busId}")
    public ResponseEntity<BusOperatorDTO> getBusByBusId(@PathVariable String busId){
        BusOperatorDTO busByBusId = busService.getBusByBusId(busId);
        System.out.println(busByBusId);
        return new ResponseEntity<>(busByBusId,HttpStatus.FOUND);

    }

    // get by bus number ; http://localhost:8080/api/bus-operator/{busNumber}
    @GetMapping("busNum/{busNum}")
    public ResponseEntity<BusOperatorDTO> getBusByBusNumber(@PathVariable Integer busNum){
        System.out.println(busNum);
        BusOperatorDTO busByBusId = busService.getBusByBusNumber(busNum);
        return new ResponseEntity<>(busByBusId,HttpStatus.FOUND);

    }
    // get by bus Type ; http://localhost:8080/api/bus-operator/busType/{busType}
    @GetMapping("/busType/{busType}")
    public ResponseEntity<List<BusOperatorDTO>> getByBusType(@PathVariable String busType) {
        List<BusOperatorDTO> busByBusType = busService.findBusByBusType(busType);
        return new ResponseEntity<>(busByBusType, HttpStatus.FOUND);
    }

    // get by bus number ; http://localhost:8080/api/bus-operator/busDriver/{busDriver}
    @GetMapping("/busDriver/{busDriver}")
    public ResponseEntity<BusOperatorDTO> findByDriverName(@PathVariable String busDriver){
        BusOperatorDTO byBusDriverName = busService.findByBusDriverName(busDriver);
        return new ResponseEntity<>(byBusDriverName,HttpStatus.FOUND);
    }
//use querry parameter for these
    // get by departure date : http://localhost:8080/api/bus-operator?departureDate=YYYY-MM-DD
//    @GetMapping
//    public ResponseEntity<List<BusOperatorDTO>> getByDepartureDate(@RequestParam Date departureDate){
//        List<BusOperatorDTO> ByDate = busService.findByDepartureDate(departureDate);
//        return new ResponseEntity<>(ByDate,HttpStatus.FOUND);
//    }

  //   get by departure date : http://localhost:8080/api/bus-operator/Operator/{Operator}
    @GetMapping("/Operator/{Operator}")
    public ResponseEntity<List<BusOperatorDTO>> ByOperatorName(@PathVariable String Operator){
        List<BusOperatorDTO> byOperatorName = busService.findByOperatorName(Operator);
        return new ResponseEntity<>(byOperatorName,HttpStatus.FOUND);
    }

}
/// All by query parameters

//
//    // http://localhost:8080/api/bus-operator
//    @GetMapping
//    public ResponseEntity<List<BusOperatorDTO>> getAllBusDetails(){
//        List<BusOperatorDTO> allBusses = busService.getAllBusses();
//        return new ResponseEntity<>(allBusses,HttpStatus.OK);
//    }
//    // get by bus Id ; http://localhost:8080/api/bus-operator?busId = {busId}
//    @GetMapping
//    public ResponseEntity<BusOperatorDTO> getBusByBusId(@RequestParam String busId){
//        BusOperatorDTO busByBusId = busService.getBusByBusId(busId);
//        return new ResponseEntity<>(busByBusId,HttpStatus.FOUND);
//
//    }
//
//    // get by bus number ; http://localhost:8080/api/bus-operator?busNum={busNumber}
//    @GetMapping
//    public ResponseEntity<BusOperatorDTO> getBusByBusNumber(@RequestParam String busNum){
//        BusOperatorDTO busByBusId = busService.getBusByBusNumber(busNum);
//        return new ResponseEntity<>(busByBusId,HttpStatus.FOUND);
//
//    }
//    // get by bus number ; http://localhost:8080/api/bus-operator?busType = {busType}
//    @GetMapping
//    public ResponseEntity<List<BusOperatorDTO>> getByBusType(@RequestParam String busType){
//        List<BusOperatorDTO> busByBusType = busService.findBusByBusType(busType);
//        return new ResponseEntity<>(busByBusType,HttpStatus.FOUND);
//    }
// get by bus number ; http://localhost:8080/api/bus-operator?driverName={busDriver}
//@GetMapping
//public ResponseEntity<BusOperatorDTO> findByDriverName(@RequestParam String driverName){
//    BusOperatorDTO byBusDriverName = busService.findByBusDriverName(busDriver);
//    return new ResponseEntity<>(byBusDriverName,HttpStatus.FOUND);
//}
//
//}
