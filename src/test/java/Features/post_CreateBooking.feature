# language: es

Característica: Crear una nueva reserva

  Esquema del escenario: : Generar un nuevo id para una nueva reserva
    Dado se ingreso el "<endpoint>" correcto
    Y los datos sean "<firstname>", "<lastname>", "<totalprice>", "<depositpaid>", "<checkin>", "<checkout>", "<additionalneeds>"
    Cuando se ejecuta la peticion
    Y se validara que el status es 200
    Entonces la nueva reserva esta asignada a "<firstname>" y "<lastname>"


    Ejemplos:
      | endpoint | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds     |
      | booking  | Digna     | Cuya     | 1207       | true        | 2024-02-01 | 2024-02-27 | No incluye desayuno |
