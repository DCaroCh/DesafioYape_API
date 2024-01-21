# language: es

Característica: Editar una reserva registrada

  @Test
  Esquema del escenario: Editar los datos de la reserva de un usuario

    Dado se genera la url del booking a actualizar con id "<id>"
    Cuando los datos a editar son "<firstname>", "<lastname>", "<totalprice>", "<depositpaid>", "<checkin>", "<checkout>", "<additionalneeds>"
    Entonces se validara que el status es 200
    Y se valida la actualizacion con los nuevos datos "<firstname>", "<lastname>", "<totalprice>", "<depositpaid>", "<checkin>", "<checkout>", "<additionalneeds>"

    Ejemplos:
      | id  | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds     |
      | 156 | Digna     | Cuya     | 999        | true        | 2023-02-01 | 2023-02-01 | No incluye desayuno |