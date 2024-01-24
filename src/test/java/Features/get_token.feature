# language: es

Característica: Obtener token para editar y eliminar reservas

  Esquema del escenario: Generar token correcto de acceso

    Dado se ingreso el "<endpoint>" correcto
    Cuando el usuario es "<user>" y la clave es "<pass>"
    Entonces se validara que el status es 200

    Ejemplos:
      | endpoint | user   | pass        |
      | auth     | admin  | password123 |
      | auth     | 465465 | 6545465544  |

  Esquema del escenario: Validar que no genere token al ingresar credenciales no validas

    Dado se ingreso el "<endpoint>" correcto
    Cuando el usuario es "<user>" y la clave es "<pass>"
    Entonces se validara que la respuesta sea Bad Credentials

    Ejemplos:
      | endpoint | user   | pass |
      | auth     | (*^^*) | */*/ |