# language: es

Característica: Eliminar una reserva

  Esquema del escenario: Eliminar una reserva existente

    Dado se genera la url del booking a actualizar con "<id>"
    Cuando se ejecuta la peticion delete
    Entonces se validara que el status es 201

    Ejemplos:

    |id|
    |3|

  Esquema del escenario: Eliminar una reserva inexistente

    Dado se genera la url del booking a actualizar con "<id>"
    Cuando se ejecuta la peticion delete
    Entonces se validara que el status es 405

    Ejemplos:

    |id|
    |793279821|



