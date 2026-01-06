package com.codegnan.dao;

import java.util.List;
import com.codegnan.model.Vehicle;
import com.codegnan.exceptions.VehicleNotFoundException;

public interface VehicleDao {

    void save(Vehicle vehicle);

    Vehicle findById(int id) throws VehicleNotFoundException;

    List<Vehicle> findAll();

    void update(Vehicle vehicle) throws VehicleNotFoundException;

    void deleteById(int id) throws VehicleNotFoundException;
}
