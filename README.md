# Api seleccionada: gestion de vehiculos.

# 1. Microservicio Seleccionado: "Gestión de Vehículos"
Se elige este microservicio porque es el corazón operativo de la plataforma multimodal (bicicletas, scooters, autos) y permite demostrar fácilmente la escalabilidad independiente

# 2. Justificación Técnica: ¿Por qué Microservicios?
Para tu presentación, justifica la elección frente a un monolito con estos puntos clave de las fuentes:
- Escalabilidad ante picos de demanda: El requerimiento exige soportar decenas de miles de usuarios concurrentes y picos en horas punta
. Los microservicios permiten escalar solo el servicio de "Gestión de Vehículos" (donde los usuarios consultan disponibilidad) sin necesidad de escalar todo el sistema, optimizando costos
.
- Disponibilidad y Resiliencia: Se requiere un 99.9% de disponibilidad
. En un monolito, un error en el módulo de pagos podría tirar toda la aplicación; con microservicios, si el sistema de "Reputación" falla, los usuarios aún pueden reservar un vehículo
.
- Crecimiento y Expansión: La empresa planea expandirse a múltiples ciudades en 5 años
. Una arquitectura de microservicios facilita agregar nuevas ciudades o nuevos medios de transporte (como buses) de forma independiente y rápida
.
- Alineación con el Equipo: El caso menciona que el equipo está formado por varios equipos pequeños
. Esto encaja perfectamente con el modelo de microservicios, donde cada equipo tiene autonomía total sobre su servicio


Caso de estudio: Plataforma Integral de Movilidad
Urbana

# Contexto
Una empresa tecnológica quiere desarrollar una plataforma integral de movilidad urbana
que unifique distintos medios de transporte disponibles en la ciudad: taxis, autos
compartidos, bicicletas eléctricas, scooters y transporte público.
El objetivo es que los usuarios puedan planificar, reservar y pagar trayectos completos
desde una única aplicación, combinando distintos medios de transporte.
La empresa planea lanzar el sistema inicialmente en una ciudad grande, con la expectativa
de expandirse a múltiples ciudades en Latinoamérica en los próximos 5 años.
El equipo de desarrollo está formado por varios equipos pequeños, por lo que se busca
una arquitectura que permita dividir responsabilidades en servicios independientes.

# Objetivo del sistema

Desarrollar una plataforma digital que permita:
• Planificar rutas multimodales
• Reservar y gestionar viajes
• Gestionar conductores y vehículos
• Procesar pagos
• Proveer información en tiempo real

# Requerimientos funcionales
1. Gestión de usuarios
• Registro y autenticación de usuarios.
• Gestión de perfiles.
• Métodos de pago asociados.

3. Gestión de conductores
• Registro de conductores.
• Validación de documentos.
• Disponibilidad en línea/offline.

4. Gestión de vehículos
• Registro de autos, bicicletas y scooters.
• Estado del vehículo (disponible, reservado, en uso, mantenimiento).

5. Planificación de rutas
• El usuario puede ingresar origen y destino.
• El sistema propone múltiples rutas posibles combinando transportes.
• Muestra tiempo estimado y costo aproximado.

6. Gestión de viajes
• Crear viaje.
• Asignar conductor o vehículo disponible.
• Seguimiento en tiempo real del trayecto.

7. Pagos
• Pago con tarjeta o billetera digital.
• Cálculo automático del costo final del viaje.
• Generación de recibos.

8. Sistema de notificaciones
• Confirmación de reserva.
• Llegada del conductor.
• Fin del viaje.

9. Sistema de reputación
• Usuarios califican conductores.
• Conductores califican pasajeros.

# Requerimientos no funcionales

• Soportar decenas de miles de usuarios concurrentes.
• Disponibilidad mínima 99.9%.
• Tiempo de respuesta inferior a 2 segundos para operaciones comunes.
• Capacidad de agregar nuevas ciudades fácilmente.
• Integración con APIs externas de mapas y transporte público.
• Escalabilidad ante picos de demanda (horas punta)


Integrantes:
Paz Molina
Jordan Villegas
Guerben cajuste
