package com.codegnan.controller;

import com.codegnan.model.Vehicle;
import com.codegnan.service.VehicleService;
import com.codegnan.service.VehicleServiceImpl;

public class VehicleController {

    public static void main(String[] args) throws Exception {

        VehicleService service = new VehicleServiceImpl();

        System.out.println("VEHICLE MANAGEMENT\n");

        service.addVehicle(new Vehicle(101, "Honda City", "TS09AB1234", 1200000));
        service.addVehicle(new Vehicle(102, "Tata Nexon", "TS07BR4455", 950000));
        service.addVehicle(new Vehicle(103, "Hyundai i20", "TS05CD7788", 850000));

        System.out.println("Vehicles Added Successfully\n");

        System.out.println("=== All Vehicles ===");
        service.getAllVehicles().forEach(System.out::println);

        System.out.println("\n=== Searching Vehicle ID 102 ===");
        System.out.println(service.getVehicleById(102));

        System.out.println("\n=== Updating Vehicle ID 101 ===");
        service.updateVehicle(new Vehicle(101, "Honda City", "TS09AB1234", 1250000));

        System.out.println("\n=== After Update ===");
        service.getAllVehicles().forEach(System.out::println);

        System.out.println("\n=== Deleting Vehicle ID 103 ===");
        service.deleteVehicle(103);

        System.out.println("\n=== Final List ===");
        service.getAllVehicles().forEach(System.out::println);
    }
}
