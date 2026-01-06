package com.codegnan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.exceptions.VehicleNotFoundException;
import com.codegnan.model.Vehicle;
import com.codegnan.util.DBUtil;

public class VehicleDaoImpl implements VehicleDao {

    @Override
    public void save(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle VALUES (?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, vehicle.getId());
            ps.setString(2, vehicle.getBrand());
            ps.setString(3, vehicle.getModel());
            ps.setDouble(4, vehicle.getPrice());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle findById(int id) throws VehicleNotFoundException {
        String sql = "SELECT * FROM vehicle WHERE id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Vehicle(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        throw new VehicleNotFoundException("Vehicle not found");
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> list = new ArrayList<>();
        String sql = "SELECT * FROM vehicle";

        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Vehicle(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getDouble("price")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void update(Vehicle vehicle) throws VehicleNotFoundException {
        String sql = "UPDATE vehicle SET brand=?, model=?, price=? WHERE id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vehicle.getBrand());
            ps.setString(2, vehicle.getModel());
            ps.setDouble(3, vehicle.getPrice());
            ps.setInt(4, vehicle.getId());

            if (ps.executeUpdate() == 0) {
                throw new VehicleNotFoundException("Vehicle not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) throws VehicleNotFoundException {
        String sql = "DELETE FROM vehicle WHERE id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            if (ps.executeUpdate() == 0) {
                throw new VehicleNotFoundException("Vehicle not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
