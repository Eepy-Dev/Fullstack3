# Fullstack3

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

Guerben cajuste
