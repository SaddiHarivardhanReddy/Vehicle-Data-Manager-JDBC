package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.VehicleDao;
import com.codegnan.dao.VehicleDaoImpl;
import com.codegnan.exceptions.VehicleNotFoundException;
import com.codegnan.model.Vehicle;

public class VehicleServiceImpl implements VehicleService {

    private VehicleDao dao = new VehicleDaoImpl();

    @Override
    public void addVehicle(Vehicle vehicle) {
        dao.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return dao.findAll();
    }

    @Override
    public Vehicle getVehicleById(int id) throws VehicleNotFoundException {
        return dao.findById(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) throws VehicleNotFoundException {
        dao.update(vehicle);
    }

    @Override
    public void deleteVehicle(int id) throws VehicleNotFoundException {
        dao.deleteById(id);
    }
}
