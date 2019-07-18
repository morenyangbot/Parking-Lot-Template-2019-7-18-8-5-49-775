package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.Car;
import com.thoughtworks.parking_lot.entity.Order;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.OrderService;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController implements BaseController<ParkingLot, String> {

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private OrderService orderService;

    @Override
    public ParkingLot save(@RequestBody ParkingLot parkingLot) {
        return parkingLotService.save(parkingLot);
    }

    @Override
    public List<ParkingLot> findAll() {
        List<ParkingLot> parkingLots = parkingLotService.findAll();
        return parkingLots;
    }

    @Override
    public Page<ParkingLot> findAll(@PageableDefault(size = 15) Pageable pageable) {
        return parkingLotService.findAll(pageable);
    }

    @Override
    public ParkingLot findById(@PathVariable String id) throws Exception {
        return parkingLotService.findById(id).orElseThrow(() -> new Exception("Parking lot not found."));
    }

    @Override
    public void deleteById(String s) {
        parkingLotService.deleteById(s);
    }

    @Override
    public ParkingLot update(ParkingLot parkingLot) {
        return parkingLotService.save(parkingLot);
    }

    @PostMapping("/{id}/orders")
    public Order parkCar(@PathVariable String id, @RequestBody Car car) throws Exception {
        return parkingLotService.parkCar(id, car);
    }

    @PutMapping("/{id}/orders/{orderId}")
    public Order fetchCar(@PathVariable String id, @PathVariable String orderId) throws Exception{
        return parkingLotService.fetchCar(id, orderId);
    }

}
