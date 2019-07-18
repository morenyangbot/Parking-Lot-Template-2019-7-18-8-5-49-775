package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.Car;
import com.thoughtworks.parking_lot.entity.Order;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repo.OrderRepository;
import com.thoughtworks.parking_lot.repo.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService implements BaseService<ParkingLot, String> {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order parkCar(String id, Car car) throws Exception {
        ParkingLot parkingLot = parkingLotRepository.findById(id).orElseThrow(() -> new RuntimeException("Parking lot not found"));
        if (parkingLot.isFull()) {
            throw new RuntimeException("Parking lot full");
        }
        Order order = new Order(parkingLot, car);
        return orderRepository.save(order);
    }

    public Order fetchCar(String id, String orderId) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(false);
        order.setLeaveTime(new Date().getTime());
        return orderRepository.save(order);
    }

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
