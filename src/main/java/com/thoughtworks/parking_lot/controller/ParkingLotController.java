package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
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

    @Override
    public ParkingLot save(@RequestBody ParkingLot parkingLot) {
        return parkingLotService.save(parkingLot);
    }

    @Override
    public List<ParkingLot> findAll() {
        return parkingLotService.findAll();
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

}
