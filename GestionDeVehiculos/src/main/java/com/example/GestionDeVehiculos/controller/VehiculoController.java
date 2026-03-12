package com.example.GestionDeVehiculos.controller;

import com.example.GestionDeVehiculos.model.Vehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private static List<Vehiculo> baseDeDatosSimulada = new ArrayList<>();

    @GetMapping
    public List<Vehiculo> obtenerTodos() {
        return baseDeDatosSimulada;
    }

    @PostMapping
    public ResponseEntity<Vehiculo> registrarVehiculo(@RequestBody Vehiculo nuevoVehiculo) {
        nuevoVehiculo.setId((long) (baseDeDatosSimulada.size() + 1));
        if (nuevoVehiculo.getEstado() == null) {
            nuevoVehiculo.setEstado("DISPONIBLE");
        }
        baseDeDatosSimulada.add(nuevoVehiculo);
        return new ResponseEntity<>(nuevoVehiculo, HttpStatus.CREATED);
    }
}