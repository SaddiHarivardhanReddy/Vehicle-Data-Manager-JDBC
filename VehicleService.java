package com.codegnan.service;

import java.util.List;
import com.codegnan.model.Vehicle;
import com.codegnan.exceptions.VehicleNotFoundException;

public interface VehicleService {

    void addVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(int id) throws VehicleNotFoundException;

    void updateVehicle(Vehicle vehicle) throws VehicleNotFoundException;

    void deleteVehicle(int id) throws VehicleNotFoundException;
}
