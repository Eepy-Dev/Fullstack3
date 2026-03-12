package com.example.GestionDeVehiculos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionDeVehiculos.model.Vehiculos;
import com.example.GestionDeVehiculos.repository.VehiculoRepository;

@Service
public class VehiculoService {

    private final VehiculoRepository repo;

    public VehiculoService(VehiculoRepository repo) {
        this.repo = repo;
    }

    public List<Vehiculos> getAllVehiculos() {
        return repo.findAll();
    }

    public Vehiculos getVehiculoById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Vehiculos> getVehiculosByEstado(String estado) {
        return repo.findByEstado(estado);
    }

    public Vehiculos updateVehiculo(Long id, Vehiculos vehiculo) {
        Vehiculos existingVehiculo = repo.findById(id).orElse(null);
        if (existingVehiculo != null) {
            existingVehiculo.setTipo(vehiculo.getTipo());
            existingVehiculo.setMarca(vehiculo.getMarca());
            existingVehiculo.setModelo(vehiculo.getModelo());
            existingVehiculo.setAnio(vehiculo.getAnio());
            existingVehiculo.setColor(vehiculo.getColor());
            existingVehiculo.setPlaca(vehiculo.getPlaca());
            existingVehiculo.setEstado(vehiculo.getEstado());
            existingVehiculo.setCiudad(vehiculo.getCiudad());
            return repo.save(existingVehiculo);
        }
        return null;
    }

    public Vehiculos saveVehiculo(Vehiculos vehiculo) {
        return repo.save(vehiculo);
    }

    public void deleteVehiculo(Long id) {
        repo.deleteById(id);
    } 



}

