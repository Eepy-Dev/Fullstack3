package com.example.GestionDeVehiculos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeVehiculos.model.Vehiculos;
import com.example.GestionDeVehiculos.service.VehiculoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/vehiculos")
@Tag(name = "Vehículos", description = "API para la gestión de vehículos")
public class VehiculoController {

    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    // GET /api/vehiculos → Listar todos los vehículos
    @GetMapping
    @Operation(summary = "Listar todos los vehículos", description = "Obtiene una lista de todos los vehículos registrados en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista de vehículos obtenida exitosamente")
    public List<Vehiculos> listar() {
        return service.getAllVehiculos();
    }

    // GET /api/vehiculos/{id} → Buscar por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener vehículo por ID", description = "Busca y retorna un vehículo específico por su identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vehículo encontrado"),
            @ApiResponse(responseCode = "404", description = "Vehículo no encontrado")
    })
    public ResponseEntity<Vehiculos> buscarPorId(
            @Parameter(description = "ID del vehículo a buscar") @PathVariable Long id) {
        return ResponseEntity.ok(service.getVehiculoById(id));
    }

    // GET /api/vehiculos/estado/{estado} → Filtrar por estado
    @GetMapping("/estado/{estado}")
    @Operation(summary = "Filtrar vehículos por estado", description = "Obtiene todos los vehículos que coinciden con el estado especificado")
    @ApiResponse(responseCode = "200", description = "Lista de vehículos con el estado solicitado")
    public List<Vehiculos> porEstado(
            @Parameter(description = "Estado del vehículo (ej: Activo, Mantenimiento, Inactivo)") @PathVariable String estado) {
        return service.getVehiculosByEstado(estado);
    }

    // POST /api/vehiculos → Registrar un nuevo vehículo
    @PostMapping
    @Operation(summary = "Crear nuevo vehículo", description = "Registra un nuevo vehículo en el sistema con la información proporcionada")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Vehículo creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    public ResponseEntity<Vehiculos> crear(
            @Parameter(description = "Datos del vehículo a crear") @RequestBody Vehiculos vehiculo) {
        return ResponseEntity.status(201).body(service.saveVehiculo(vehiculo));
    }

    // PUT /api/vehiculos/{id} → Actualizar un vehículo existente
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar vehículo", description = "Actualiza los datos de un vehículo existente en el sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vehículo actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Vehículo no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    public ResponseEntity<Vehiculos> actualizar(
            @Parameter(description = "ID del vehículo a actualizar") @PathVariable Long id,
            @Parameter(description = "Nuevos datos del vehículo") @RequestBody Vehiculos datos) {
        return ResponseEntity.ok(service.updateVehiculo(id, datos));
    }

    // DELETE /api/vehiculos/{id} → Eliminar un vehículo
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar vehículo", description = "Elimina un vehículo del sistema de forma permanente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Vehículo eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Vehículo no encontrado")
    })
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del vehículo a eliminar") @PathVariable Long id) {
        service.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }
}
