# language: es

Característica: Muestra la lista de los códigos de las reservas que existen en el api

  Esquema del escenario: Listar todos los códigos de reservas

    Dado se ingreso el "<endpoint>" correcto
    Cuando se ejecuta la peticion
    Entonces se lista todos los codigos de reservas

    Ejemplos:
      | endpoint |
      | booking  |

  Esquema del escenario: Mostrar código de reserva de usuario filtrando por nombre y apellido alfabeticos

    Dado se ingreso el "<endpoint>" correcto
    Y se ingreso el "<firstName>" y el "<lastName>"
    Cuando se ejecuta la peticion
    Entonces se mostrara la lista de Booking id del usuario

    Ejemplos:
      | endpoint | firstName | lastName |
      | booking  | John      | Smith    |


  Esquema del escenario: Mostrar código de reserva de usuario filtrando por nombre y apellido con datos incorrectos

    Dado se ingreso el "<endpoint>" correcto
    Y se ingreso el "<firstName>" y el "<lastName>"
    Cuando se ejecuta la peticion
    Entonces se validara una lista vacia

    Ejemplos:
      | endpoint | firstName | lastName |
      | booking  | ####$#$   | *#@***   |
      | booking  | 5456441   | 456454   |
      | booking  | Carolina  |          |

  Esquema del escenario: Mostrar código de reserva de usuarios filtrando por nombre

    Dado se ingreso el "<endpoint>" correcto
    Y se ingreso el "<firstName>"
    Cuando se ejecuta la peticion
    Entonces se mostrara la lista de Booking id del usuario

    Ejemplos:
      | endpoint | firstName |
      | booking  | John      |

  Esquema del escenario: Mostrar código de reserva de usuarios filtrando por apellido

    Dado se ingreso el "<endpoint>" correcto
    Y se ingreso el "<lastName>"
    Cuando se ejecuta la peticion
    Entonces se mostrara la lista de Booking id del usuario

    Ejemplos:
      | endpoint | lastName |
      | booking  | Smith    |

  Esquema del escenario: Mostrar código de reserva de usuario filtrando por checkin y checkout

    Dado se ingreso el "<endpoint>" correcto
    Y se ingreso en "<checkIn>" y el "<checkOut>"
    Cuando se ejecuta la peticion
    Entonces se mostrara la lista de Booking id del usuario

    Ejemplos:
      | endpoint | checkIn    | checkOut   |
      | booking  | 2018-01-01 | 2019-01-01 |

  Esquema del escenario: Mostrar código de reserva de usuario filtrando por checkin y checkout con datos incorrectos

    Dado se ingreso el "<endpoint>" correcto
    Y se ingreso en "<checkIn>" y el "<checkOut>"
    Cuando se ejecuta la peticion
    Entonces se validara que el status es 500

    Ejemplos:
      | endpoint | checkIn    | checkOut   |
      | booking  | 546546556  | 5464645    |
      | booking  | 29-02-2023 | 30-02-2024 |

