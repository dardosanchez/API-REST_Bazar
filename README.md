# Proyecto Integrador Final - Gestión de Bazar con Spring Boot

Este proyecto es el resultado de mi trabajo final para el curso "Desarrollo de APIs en Java con Spring Boot" de la TodoCode Academy. El objetivo principal de esta aplicación es ayudar a un bazar a gestionar sus ventas y productos de manera eficiente.

## Descripción del Escenario

Hemos experimentado un aumento significativo en nuestras ventas y necesitábamos una solución para registrarlas y gestionar nuestro inventario de productos de manera automatizada. La aplicación debía ser capaz de servir a dos tipos de clientes HTTP:

1. Una aplicación web con un frontend desarrollado por un tercero.
2. Una futura aplicación móvil.

Para lograr esto, desarrollé una API en Java utilizando Spring Boot que puede ser utilizada por ambos tipos de clientes.

## Modelado de Datos

Identifiqué tres clases principales en nuestro modelo de datos:

- Producto
- Venta
- Cliente

Cada una de estas clases tiene atributos específicos que se detallan en el código del proyecto.

## Requerimientos Implementados

He implementado los siguientes requerimientos en esta aplicación:

1. **CRUD de Productos**
   - Métodos HTTP: GET, POST, DELETE, PUT
   - Endpoints: Consultar producto, crear producto, listar productos, eliminar producto, editar producto.

2. **CRUD de Clientes**
   - Métodos HTTP: GET, POST, DELETE, PUT
   - Endpoints: Consultar cliente, crear cliente, listar clientes, eliminar cliente, editar cliente.

3. **CRUD de Ventas**
   - Métodos HTTP: GET, POST, DELETE, PUT
   - Endpoints: Consultar venta, crear venta, listar ventas, eliminar venta, editar venta.

4. **Obtener Productos con Cantidad Baja en Stock**
   - Métodos HTTP: GET
   - Endpoint: Consultar productos con cantidad disponible menor a 5.

5. **Obtener Lista de Productos de una Venta**
   - Métodos HTTP: GET
   - Endpoint: Consultar productos de una venta específica.

6. **Obtener Sumatoria de Monto y Cantidad Total de Ventas por Día**
   - Métodos HTTP: GET
   - Endpoint: Consultar ventas de un día específico.

7. **Obtener Datos de la Venta con el Monto Más Alto**
   - Métodos HTTP: GET
   - Endpoint: Consultar la venta con el monto más alto.

## Instalación y Configuración

Para utilizar esta aplicación en su entorno de desarrollo, siga estos pasos:

1. Clone este repositorio en su máquina local.
2. Configure las propiedades de la base de datos en el archivo `application.properties`.
3. Ejecute la aplicación utilizando Spring Boot.

## Contribuciones

Las contribuciones a este proyecto son bienvenidas. Si tiene ideas para mejoras, correcciones de errores o nuevas características, no dude en enviar una solicitud de extracción.

## Contacto

Para cualquier pregunta o comentario, no dude en ponerse en contacto conmigo, Dardo Sanchez, a través de [dardosanchez2000@gmail.com](mailto:dardosanchez2000@gmail.com).

¡Gracias por usar mi aplicación!
