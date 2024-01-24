# language: es

Característica: Editar parcialmente una reserva existente

  Esquema del escenario: Editar la fecha de la reserva existente

    Dado se concatena la url del booking a actualizar con "<id>"
    Cuando los datos a actualizar son "<checkin>" y "<checkout>"
    Entonces se validara que el status es 200
    Y se valida la actualizacion con los nuevos datos "<checkin>" y "<checkout>"

    Ejemplos:
      | id  | checkin    | checkout   |
      | 422 | 2024-03-01 | 2024-04-01 |