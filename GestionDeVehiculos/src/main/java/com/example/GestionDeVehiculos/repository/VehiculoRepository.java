package com.example.GestionDeVehiculos.repository;

import java.util.List;

import com.example.GestionDeVehiculos.model.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository  extends JpaRepository<Vehiculos, Long> {

    List<Vehiculos> findByEstado(String estado);
    List<Vehiculos> findByCiudad(String ciudad);
    List<Vehiculos> findByTipo(String tipo);
    List<Vehiculos> findByMarca(String marca);
    List<Vehiculos> findByModelo(String modelo);
    List<Vehiculos> findByAnio(String anio);
    List<Vehiculos> findByColor(String color);
    List<Vehiculos> findByPlaca(String placa);

}
