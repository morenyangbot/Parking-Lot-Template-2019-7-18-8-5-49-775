package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repo.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService implements BaseService<ParkingLot, String> {
    @Autowired
    private ParkingLotRepository parkingLotRepository;


    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public List<ParkingLot> findAll() {
        return parkingLotRepository.findAll();
    }

    @Override
    public void deleteById(String s) {
        parkingLotRepository.deleteById(s);
    }

    @Override
    public Optional<ParkingLot> findById(String s) {
        return parkingLotRepository.findById(s);
    }

    @Override
    public Page<ParkingLot> findAll(Pageable pageable) {
        return parkingLotRepository.findAll(pageable);
    }
}
