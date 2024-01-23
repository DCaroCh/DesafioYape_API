1. Plan de pruebas:

    Objetivo: Realizar el análisis para el mapeo de pruebas de la aplicación RESTFUL-BOOKER.

     - Herramientas:
       * Restassured
       * Entorno: IntellJ IDEA
       * JDK 1.8
      
     - Pruebas funcionales:
     -     Crear nuevo token:
     -         Generar token correcto de acceso
           -Validar que no genere token al ingresar credenciales no validas
  
       * Get booking:
           -Mostrar la información de la reserva con id existentes
           -Mostrar la información de la reserva con id inexistente
  
       * Get booking id:
           -Listar todos los códigos de reservas
           -Mostrar código de reserva de usuario filtrando por nombre y apellido alfabeticos
           -Mostrar código de reserva de usuario filtrando por nombre y apellido con datos incorrectos
           -Mostrar código de reserva de usuarios filtrando por nombre
           -Mostrar código de reserva de usuarios filtrando por apellido
           -Mostrar código de reserva de usuario filtrando por checkin y checkout
           -Mostrar código de reserva de usuario filtrando por checkin y checkout con datos incorrectos
  
       * Create booking:
           -Generar un nuevo id para una nueva reserva
  
       * Update boooking:
           -Editar los datos de la reserva de un usuario
  
       * PartialUpdateBooking:
           -Editar la fecha de la reserva existente
  
       * Delete booking:
           -Eliminar una reserva existente

       * Health Check:
           -Comprobar que la api esta funcionando correctamente
           -Comprobar que al escribir incorrectamente el endpoint no responda 201
  
     - Prueba especiales:
       * Pruebas de rendimiento (Pruebas de carga, picos)
       * Pruebas de seguridad

     - Observaciones:
       * Algunos campos que en la documentación figuraban como obligatorios, sin embargo, en la ejecución, se envían campos vacíos y/o data errada, y responde con un 200.
       * En el endpoint "auth", para la generación de token, las credenciales pueden ser cualquier valor alfanumérico, igual responde 200.
       * Al ser data no estática, es necesario validar la data de los ID´s antes de la ejecución de los endpoints que requieran de este campo.
       * En algunos casos se está enviando data sensible, lo cual es riesgoso, es por ello que se sugiere la ejecución de pruebas de seguridad y/o EH, para mitigar riesgos.
