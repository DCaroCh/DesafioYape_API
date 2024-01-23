# language: es

Característica: Obtener los datos específicos de la reserva usando el id
  #Validar los id y nombres en postman antes de ejecutar

  Esquema del escenario: Mostrar la información de la reserva con id existentes

    Dado se genera la url del booking con id "<id>"
    Cuando se ejecuta la peticion get
    Entonces se validara el "<nombre>" del usuario

    Ejemplos:
      | id | nombre |
      | 11 | Jane   |
      | 12 | John   |

  Esquema del escenario: Mostrar la información de la reserva con id inexistentes

    Dado se genera la url del booking con id "<id>"
    Cuando se ejecuta la peticion get
    Entonces se validara que el status es 404

    Ejemplos:
      | id        |
      | %&^SDA    |
      | (*^&&)(&) |

