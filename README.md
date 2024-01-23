1. Plan de pruebas:

    Objetivo: Realizar el análisis para el mapeo de pruebas de la aplicación RESTFUL-BOOKER.



     - Herramientas:
       * Restassured
       * Entorno: IntellJ IDEA
       * JDK 1.8
  
     - Prueba especiales:
       * Pruebas de rendimiento (Pruebas de carga, picos)
       * Pruebas de seguridad

     - Observaciones:
       * Algunos campos que en la documentación figuraban como obligatorios, sin embargo, en la ejecución, se envían campos vacíos y/o data errada, y responde con un 200.
       * En el endpoint "auth", para la generación de token, las credenciales pueden ser cualquier valor, igual responde 200.
       * Al ser data no estática, es necesario validar la data de los ID´s antes de la ejecución de los endpoints que requieran de este campo.
       * En algunos casos se está enviando data sensible, lo cual es riesgoso, es por ello que se sugiere la ejecución de pruebas de seguridad y/o EH, para mitigar riesgos.
