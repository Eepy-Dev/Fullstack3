package com.example.GestionDeVehiculos.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.GestionDeVehiculos.model.Vehiculos;
import com.example.GestionDeVehiculos.repository.VehiculoRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test suite para VehiculoService")
class VehiculoServiceTest {

    @Mock
    private VehiculoRepository vehiculoRepository;

    @InjectMocks
    private VehiculoService vehiculoService;

    private Vehiculos vehiculo;

    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculos();
        vehiculo.setId(1L);
        vehiculo.setTipo("Auto");
        vehiculo.setMarca("Toyota");
        vehiculo.setModelo("Corolla");
        vehiculo.setAnio("2023");
        vehiculo.setColor("Blanco");
        vehiculo.setPlaca("ABC1234");
        vehiculo.setEstado("Activo");
        vehiculo.setCiudad("Santiago");
    }

    @Test
    @DisplayName("Debe obtener todos los vehículos")
    void testGetAllVehiculos() {
        // Arrange
        Vehiculos vehiculo2 = new Vehiculos(2L, "Camioneta", "Ford", "Ranger", "2022", "Rojo", 
                                            "DEF5678", "Mantenimiento", "Valparaiso");
        List<Vehiculos> vehiculos = Arrays.asList(vehiculo, vehiculo2);
        when(vehiculoRepository.findAll()).thenReturn(vehiculos);

        // Act
        List<Vehiculos> resultado = vehiculoService.getAllVehiculos();

        // Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Toyota", resultado.get(0).getMarca());
        assertEquals("Ford", resultado.get(1).getMarca());
        verify(vehiculoRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Debe obtener vehículo por ID exitosamente")
    void testGetVehiculoById() {
        // Arrange
        when(vehiculoRepository.findById(1L)).thenReturn(Optional.of(vehiculo));

        // Act
        Vehiculos resultado = vehiculoService.getVehiculoById(1L);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Toyota", resultado.getMarca());
        verify(vehiculoRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Debe retornar null cuando vehículo no existe por ID")
    void testGetVehiculoByIdNotFound() {
        // Arrange
        when(vehiculoRepository.findById(999L)).thenReturn(Optional.empty());

        // Act
        Vehiculos resultado = vehiculoService.getVehiculoById(999L);

        // Assert
        assertNull(resultado);
        verify(vehiculoRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Debe obtener vehículos filtrados por estado")
    void testGetVehiculosByEstado() {
        // Arrange
        Vehiculos vehiculo2 = new Vehiculos(2L, "Camioneta", "Ford", "Ranger", "2022", "Rojo", 
                                            "DEF5678", "Activo", "Valparaiso");
        List<Vehiculos> vehiculosActivos = Arrays.asList(vehiculo, vehiculo2);
        when(vehiculoRepository.findByEstado("Activo")).thenReturn(vehiculosActivos);

        // Act
        List<Vehiculos> resultado = vehiculoService.getVehiculosByEstado("Activo");

        // Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertTrue(resultado.stream().allMatch(v -> v.getEstado().equals("Activo")));
        verify(vehiculoRepository, times(1)).findByEstado("Activo");
    }

    @Test
    @DisplayName("Debe guardar un nuevo vehículo")
    void testSaveVehiculo() {
        // Arrange
        when(vehiculoRepository.save(any(Vehiculos.class))).thenReturn(vehiculo);

        // Act
        Vehiculos resultado = vehiculoService.saveVehiculo(vehiculo);

        // Assert
        assertNotNull(resultado);
        assertEquals("Toyota", resultado.getMarca());
        verify(vehiculoRepository, times(1)).save(any(Vehiculos.class));
    }

    @Test
    @DisplayName("Debe actualizar un vehículo existente")
    void testUpdateVehiculo() {
        // Arrange
        Vehiculos vehiculoActualizado = new Vehiculos(1L, "Auto", "Toyota", "Corolla", "2024", 
                                                       "Gris", "ABC1234", "Mantenimiento", "Santiago");
        when(vehiculoRepository.findById(1L)).thenReturn(Optional.of(vehiculo));
        when(vehiculoRepository.save(any(Vehiculos.class))).thenReturn(vehiculoActualizado);

        // Act
        Vehiculos resultado = vehiculoService.updateVehiculo(1L, vehiculoActualizado);

        // Assert
        assertNotNull(resultado);
        assertEquals("Gris", resultado.getColor());
        assertEquals("2024", resultado.getAnio());
        assertEquals("Mantenimiento", resultado.getEstado());
        verify(vehiculoRepository, times(1)).findById(1L);
        verify(vehiculoRepository, times(1)).save(any(Vehiculos.class));
    }

    @Test
    @DisplayName("Debe retornar null al actualizar vehículo inexistente")
    void testUpdateVehiculoNotFound() {
        // Arrange
        when(vehiculoRepository.findById(999L)).thenReturn(Optional.empty());

        // Act
        Vehiculos resultado = vehiculoService.updateVehiculo(999L, vehiculo);

        // Assert
        assertNull(resultado);
        verify(vehiculoRepository, times(1)).findById(999L);
        verify(vehiculoRepository, never()).save(any());
    }

    @Test
    @DisplayName("Debe eliminar un vehículo")
    void testDeleteVehiculo() {
        // Act
        vehiculoService.deleteVehiculo(1L);

        // Assert
        verify(vehiculoRepository, times(1)).deleteById(1L);
    }

}
